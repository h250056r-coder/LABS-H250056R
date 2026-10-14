/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 4, Challenge */
import java.util.ArrayList;
import java.util.List;

public class Q5_CompositionStack {
    static class Stack<T> {
        private final List<T> items = new ArrayList<>();
        void push(T value) { items.add(value); }
        T pop() { if (items.isEmpty()) throw new IllegalStateException("Stack is empty"); return items.remove(items.size() - 1); }
        T peek() { if (items.isEmpty()) throw new IllegalStateException("Stack is empty"); return items.get(items.size() - 1); }
        int size() { return items.size(); }
    }
    public static void main(String[] args) {
        Stack<String> studyNotes = new Stack<>();
        studyNotes.push("Encapsulation"); studyNotes.push("Inheritance");
        System.out.println("Top note: " + studyNotes.peek());
        System.out.println("Removed: " + studyNotes.pop() + "; notes left: " + studyNotes.size());
        System.out.println("An ArrayList subclass would expose operations such as remove(0), which breaks stack-only access.");
    }
}
