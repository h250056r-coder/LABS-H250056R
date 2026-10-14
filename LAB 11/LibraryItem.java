/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 11 mini-project */
import java.time.LocalDate;

public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank() || title == null || title.isBlank()) throw new IllegalArgumentException("Item id and title are required.");
        this.id = id.trim(); this.title = title.trim();
    }
    public abstract int loanPeriodDays();
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    void restoreAvailability(boolean value) { available = value; }
    @Override public void borrow(Member member, LocalDate dueDate) throws ItemNotAvailableException {
        if (member == null || dueDate == null || dueDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("A member and a valid due date are required.");
        if (!available) throw new ItemNotAvailableException("'" + title + "' is already on loan.");
        available = false;
    }
    @Override public void giveBack() { available = true; }
    @Override public String toString() {
        return String.format("%s | %s | %s | %s", id, getClass().getSimpleName(), title, available ? "Available" : "On loan");
    }
}
