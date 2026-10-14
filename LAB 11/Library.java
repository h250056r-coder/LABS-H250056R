/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 11 mini-project */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Library {
    private static final int MEMBER_LIMIT = 3;
    private final Map<String, LibraryItem> items = new LinkedHashMap<>();
    private final Map<String, Member> members = new LinkedHashMap<>();
    private final Map<String, Loan> loans = new LinkedHashMap<>();

    public void addItem(LibraryItem item) {
        if (item == null) throw new IllegalArgumentException("An item is required.");
        if (items.putIfAbsent(item.getId(), item) != null) throw new IllegalArgumentException("That item id is already in use.");
    }

    public void register(Member member) {
        if (member == null) throw new IllegalArgumentException("A member is required.");
        if (members.putIfAbsent(member.getId(), member) != null) throw new IllegalArgumentException("That member id is already registered.");
    }

    public Loan borrow(String memberId, String itemId) throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);
        if (member == null || item == null) throw new IllegalArgumentException("Check the member id and item id.");
        if (member.getActiveItemIds().size() >= MEMBER_LIMIT)
            throw new MemberLimitExceededException("A member can have at most three items at once.");

        LocalDate dueDate = LocalDate.now().plusDays(item.loanPeriodDays());
        item.borrow(member, dueDate);
        Loan loan = new Loan(itemId, memberId, dueDate);
        member.addLoan(itemId);
        loans.put(itemId, loan);
        return loan;
    }

    public void giveBack(String memberId, String itemId) {
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);
        Loan loan = loans.get(itemId);
        if (member == null || item == null || loan == null || !loan.getMemberId().equals(memberId))
            throw new IllegalArgumentException("No active loan matches that member and item.");
        item.giveBack();
        member.removeLoan(itemId);
        loans.remove(itemId);
    }

    public List<LibraryItem> allItems() { return List.copyOf(items.values()); }
    public List<Member> allMembers() { return List.copyOf(members.values()); }
    public List<Loan> overdueLoans() { return loans.values().stream().filter(Loan::isOverdue).toList(); }

    public List<LibraryItem> searchByTitle(String text) {
        String query = text == null ? "" : text.toLowerCase(Locale.ROOT).trim();
        return items.values().stream()
                .filter(item -> item.getTitle().toLowerCase(Locale.ROOT).contains(query))
                .sorted(Comparator.comparing(LibraryItem::getTitle, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }

    /** Writes a replacement file first, so an interrupted save does not truncate the last good copy. */
    public void save(Path file) throws IOException {
        Path absoluteFile = file.toAbsolutePath();
        Path parent = absoluteFile.getParent();
        if (parent != null) Files.createDirectories(parent);
        Path temporary = absoluteFile.resolveSibling(absoluteFile.getFileName() + ".tmp");

        List<String> rows = new ArrayList<>();
        for (LibraryItem item : items.values()) {
            rows.add(csvRow("ITEM", item instanceof Book ? "BOOK" : "DVD", item.getId(), item.getTitle(), Boolean.toString(item.isAvailable())));
        }
        for (Member member : members.values()) rows.add(csvRow("MEMBER", member.getId(), member.getName()));
        for (Loan loan : loans.values()) rows.add(csvRow("LOAN", loan.getItemId(), loan.getMemberId(), loan.getDueDate().toString()));

        Files.write(temporary, rows, StandardCharsets.UTF_8);
        try {
            Files.move(temporary, absoluteFile, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (AtomicMoveNotSupportedException ex) {
            Files.move(temporary, absoluteFile, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    /** Loads into temporary maps and swaps them in only after every row and relationship is valid. */
    public void load(Path file) throws IOException {
        if (!Files.exists(file)) return;

        Map<String, LibraryItem> loadedItems = new LinkedHashMap<>();
        Map<String, Member> loadedMembers = new LinkedHashMap<>();
        Map<String, Loan> loadedLoans = new LinkedHashMap<>();
        Map<String, Boolean> savedAvailability = new LinkedHashMap<>();
        int lineNumber = 0;

        for (String row : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            lineNumber++;
            if (row.isBlank()) continue;
            try {
                List<String> fields = parseCsvRow(row);
                String type = fields.get(0);
                switch (type) {
                    case "ITEM" -> {
                        requireFieldCount(fields, 5);
                        LibraryItem item = switch (fields.get(1)) {
                            case "BOOK" -> new Book(fields.get(2), fields.get(3));
                            case "DVD" -> new Dvd(fields.get(2), fields.get(3));
                            default -> throw new IllegalArgumentException("Item type must be BOOK or DVD.");
                        };
                        boolean available = parseBoolean(fields.get(4));
                        if (loadedItems.putIfAbsent(item.getId(), item) != null) throw new IllegalArgumentException("Duplicate item id " + item.getId());
                        savedAvailability.put(item.getId(), available);
                        item.restoreAvailability(available);
                    }
                    case "MEMBER" -> {
                        requireFieldCount(fields, 3);
                        Member member = new Member(fields.get(1), fields.get(2));
                        if (loadedMembers.putIfAbsent(member.getId(), member) != null) throw new IllegalArgumentException("Duplicate member id " + member.getId());
                    }
                    case "LOAN" -> {
                        requireFieldCount(fields, 4);
                        Loan loan = new Loan(fields.get(1), fields.get(2), LocalDate.parse(fields.get(3)));
                        if (loadedLoans.putIfAbsent(loan.getItemId(), loan) != null) throw new IllegalArgumentException("Duplicate active loan for item " + loan.getItemId());
                    }
                    default -> throw new IllegalArgumentException("Expected ITEM, MEMBER or LOAN row.");
                }
            } catch (RuntimeException ex) {
                throw new IOException("Invalid library-data.csv row " + lineNumber + ": " + ex.getMessage(), ex);
            }
        }

        for (Loan loan : loadedLoans.values()) {
            LibraryItem item = loadedItems.get(loan.getItemId());
            Member member = loadedMembers.get(loan.getMemberId());
            if (item == null || member == null) throw new IOException("A loan refers to a missing item or member: " + loan);
            member.addLoan(item.getId());
            if (member.getActiveItemIds().size() > MEMBER_LIMIT)
                throw new IOException("Member " + member.getId() + " has more than three active loans in the data file.");
            item.restoreAvailability(false);
        }

        for (LibraryItem item : loadedItems.values()) {
            if (savedAvailability.get(item.getId()) != item.isAvailable())
                throw new IOException("Availability does not match the active-loan rows for item " + item.getId() + ".");
        }

        items.clear(); items.putAll(loadedItems);
        members.clear(); members.putAll(loadedMembers);
        loans.clear(); loans.putAll(loadedLoans);
    }

    private static String csvRow(String... fields) {
        return java.util.Arrays.stream(fields)
                .map(value -> "\"" + value.replace("\r", " ").replace("\n", " ").replace("\"", "\"\"") + "\"")
                .collect(java.util.stream.Collectors.joining(","));
    }

    private static List<String> parseCsvRow(String row) {
        List<String> fields = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        boolean quoted = false;
        boolean afterQuote = false;
        for (int i = 0; i < row.length(); i++) {
            char current = row.charAt(i);
            if (quoted) {
                if (current == '"' && i + 1 < row.length() && row.charAt(i + 1) == '"') { value.append('"'); i++; }
                else if (current == '"') { quoted = false; afterQuote = true; }
                else value.append(current);
            } else if (current == ',' ) {
                fields.add(value.toString()); value.setLength(0); afterQuote = false;
            } else if (current == '"' && value.length() == 0 && !afterQuote) quoted = true;
            else if (afterQuote) throw new IllegalArgumentException("Unexpected text after a quoted field.");
            else value.append(current);
        }
        if (quoted) throw new IllegalArgumentException("Unclosed quoted field.");
        fields.add(value.toString());
        return fields;
    }

    private static void requireFieldCount(List<String> fields, int expected) {
        if (fields.size() != expected) throw new IllegalArgumentException("Expected " + expected + " fields, found " + fields.size() + ".");
    }

    private static boolean parseBoolean(String value) {
        if (value.equalsIgnoreCase("true")) return true;
        if (value.equalsIgnoreCase("false")) return false;
        throw new IllegalArgumentException("Availability must be true or false.");
    }
}
