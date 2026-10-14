/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 6, Intermediate 2 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q4_ComparableStudents {
    static class Student implements Comparable<Student> {
        final String name; final int marks;
        Student(String name, int marks) { this.name = name; this.marks = marks; }
        public int compareTo(Student other) { return name.compareToIgnoreCase(other.name); }
        public String toString() { return name + " (" + marks + ")"; }
    }
    public static void main(String[] args) {
        List<Student> classList = new ArrayList<>(List.of(new Student("Tariro", 78), new Student("Tishlee", 88), new Student("Anesu", 88)));
        classList.sort(null); System.out.println("Natural order, by name: " + classList);
        classList.sort(Comparator.comparingInt((Student s) -> s.marks).reversed().thenComparing(s -> s.name));
        System.out.println("Comparator order, by marks: " + classList);
    }
}
