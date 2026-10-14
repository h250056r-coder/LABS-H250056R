/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 9, Intermediate 1 */
import java.util.HashSet;
import java.util.Set;

public class Q3_BookEquality {
    static class Book {
        private final String isbn, title;
        Book(String isbn, String title) { this.isbn = isbn; this.title = title; }
        @Override public boolean equals(Object other) {
            return other instanceof Book book && isbn.equals(book.isbn);
        }
        @Override public int hashCode() { return isbn.hashCode(); }
        @Override public String toString() { return title + " [" + isbn + "]"; }
    }
    public static void main(String[] args) {
        Set<Book> shelf = new HashSet<>();
        System.out.println("First copy added: " + shelf.add(new Book("9780134685991", "Effective Java")));
        System.out.println("Duplicate ISBN added: " + shelf.add(new Book("9780134685991", "A different cover")));
        System.out.println("Unique books on shelf: " + shelf.size());
    }
}
