/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 11 mini-project */
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static final Path DATA_FILE = Path.of("library-data.csv");
    private final Library library = new Library();

    private void run() {
        try { library.load(DATA_FILE); }
        catch (IOException | RuntimeException ex) {
            System.out.println("Could not load the saved library: " + ex.getMessage());
            System.out.println("Fix or move library-data.csv before starting again; the file was left untouched.");
            return;
        }
        System.out.println("Tishlee'S HIT LIBRARY DESK  /  Harare");
        try (Scanner input = new Scanner(System.in)) {
            boolean open = true;
            while (open) {
                showMenu();
                String choice = input.nextLine().trim();
                try {
                    switch (choice) {
                        case "1" -> addItem(input);
                        case "2" -> registerMember(input);
                        case "3" -> borrow(input);
                        case "4" -> giveBack(input);
                        case "5" -> listOverdue();
                        case "6" -> search(input);
                        case "7" -> listItems();
                        case "0" -> open = false;
                        default -> System.out.println("Choose one of the menu numbers.");
                    }
                    library.save(DATA_FILE);
                } catch (ItemNotAvailableException | MemberLimitExceededException | IllegalArgumentException ex) {
                    System.out.println("Could not complete that step: " + ex.getMessage());
                } catch (IOException ex) { System.out.println("Could not save the library file: " + ex.getMessage()); }
            }
        }
        try { library.save(DATA_FILE); System.out.println("Saved. See you at the next lab session!"); }
        catch (IOException ex) { System.out.println("Could not save before closing: " + ex.getMessage()); }
    }
    private static void showMenu() {
        System.out.println("\n1 Add item  2 Register member  3 Borrow  4 Return");
        System.out.println("5 Overdue items  6 Search title  7 List items  0 Exit");
        System.out.print("Select: ");
    }
    private void addItem(Scanner input) {
        System.out.print("Type B for book or D for DVD: "); String type = input.nextLine().trim().toUpperCase();
        if (!type.equals("B") && !type.equals("D")) {
            System.out.println("Please enter B or D; no item was added.");
            return;
        }
        System.out.print("Item id: "); String id = input.nextLine();
        System.out.print("Title: "); String title = input.nextLine();
        library.addItem(type.equals("D") ? new Dvd(id, title) : new Book(id, title));
        System.out.println("Item added.");
    }
    private void registerMember(Scanner input) {
        System.out.print("Member id: "); String id = input.nextLine();
        System.out.print("Member name: "); String name = input.nextLine();
        library.register(new Member(id, name)); System.out.println("Member registered.");
    }
    private void borrow(Scanner input) throws ItemNotAvailableException, MemberLimitExceededException {
        System.out.print("Member id: "); String memberId = input.nextLine();
        System.out.print("Item id: "); String itemId = input.nextLine();
        Loan loan = library.borrow(memberId, itemId);
        System.out.println("Loan recorded. Due date: " + loan.getDueDate());
    }
    private void giveBack(Scanner input) {
        System.out.print("Member id: "); String memberId = input.nextLine();
        System.out.print("Item id: "); String itemId = input.nextLine();
        library.giveBack(memberId, itemId); System.out.println("Return recorded.");
    }
    private void listOverdue() {
        List<Loan> overdue = library.overdueLoans();
        if (overdue.isEmpty()) { System.out.println("No overdue items today."); return; }
        for (Loan loan : overdue) {
            String title = library.allItems().stream().filter(item -> item.getId().equals(loan.getItemId()))
                    .map(LibraryItem::getTitle).findFirst().orElse("Unknown title");
            System.out.printf("%s (%s), with member %s, was due %s%n", title, loan.getItemId(), loan.getMemberId(), loan.getDueDate());
        }
    }
    private void search(Scanner input) {
        System.out.print("Title contains: "); String text = input.nextLine();
        List<LibraryItem> found = library.searchByTitle(text);
        if (found.isEmpty()) System.out.println("No matching titles."); else found.forEach(System.out::println);
    }
    private void listItems() {
        if (library.allItems().isEmpty()) { System.out.println("The shelves are empty so far."); return; }
        library.allItems().forEach(System.out::println);
    }
    public static void main(String[] args) { new LibraryApp().run(); }
}
