/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 9, Intermediate 2 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Q4_IterableLinkedList {
    static class LinkedList<T> implements Iterable<T> {
        private static class Node<E> { final E value; Node<E> next; Node(E value) { this.value = value; } }
        private Node<T> head, tail;
        void add(T value) {
            Node<T> node = new Node<>(value);
            if (head == null) head = node; else tail.next = node;
            tail = node;
        }
        public Iterator<T> iterator() {
            return new Iterator<>() {
                private Node<T> current = head;
                public boolean hasNext() { return current != null; }
                public T next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    T value = current.value; current = current.next; return value;
                }
            };
        }
    }
    public static void main(String[] args) {
        LinkedList<String> timetable = new LinkedList<>();
        timetable.add("OOP lecture"); timetable.add("Library study"); timetable.add("Coffee break");
        for (String item : timetable) System.out.println("• " + item);
    }
}
