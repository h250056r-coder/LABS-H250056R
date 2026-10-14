/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 11 mini-project */
import java.time.LocalDate;

interface Borrowable {
    void borrow(Member member, LocalDate dueDate) throws ItemNotAvailableException;
    void giveBack();
}
