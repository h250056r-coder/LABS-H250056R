/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 11 mini-project */
import java.time.LocalDate;

public class Loan {
    private final String itemId;
    private final String memberId;
    private final LocalDate dueDate;
    public Loan(String itemId, String memberId, LocalDate dueDate) {
        if (itemId == null || itemId.isBlank() || memberId == null || memberId.isBlank() || dueDate == null)
            throw new IllegalArgumentException("A loan needs an item, a member and a due date.");
        this.itemId = itemId; this.memberId = memberId; this.dueDate = dueDate;
    }
    public String getItemId() { return itemId; }
    public String getMemberId() { return memberId; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isOverdue() { return dueDate.isBefore(LocalDate.now()); }
    @Override public String toString() { return itemId + " borrowed by " + memberId + ", due " + dueDate; }
}
