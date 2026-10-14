/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 8, Intermediate 1 */
import java.util.ArrayList;
import java.util.List;

public class Q3_GenericStack {
    static class Stack<T> {
        private final List<T> items = new ArrayList<>();
        void push(T item) { items.add(item); }
        boolean isEmpty() { return items.isEmpty(); }
        T peek() { if (isEmpty()) throw new IllegalStateException("Stack is empty"); return items.get(items.size() - 1); }
        T pop() { T top = peek(); items.remove(items.size() - 1); return top; }
    }
    public static void main(String[] args) {
        Stack<String> tasks = new Stack<>();
        tasks.push("Read the lab sheet"); tasks.push("Finish the Java exercises");
        System.out.println("Next: " + tasks.peek());
        System.out.println("Done: " + tasks.pop());
        System.out.println("Stack empty? " + tasks.isEmpty());
    }
}
