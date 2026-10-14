/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 11 mini-project */
public class Book extends LibraryItem {
    public Book(String id, String title) { super(id, title); }
    @Override public int loanPeriodDays() { return 14; }
}
