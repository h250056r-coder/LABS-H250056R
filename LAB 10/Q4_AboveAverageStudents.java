/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 10, Intermediate 2 */
import java.util.List;

public class Q4_AboveAverageStudents {
    record Student(String name, int marks) { }
    public static void main(String[] args) {
        List<Student> classList = List.of(new Student("Tariro", 76), new Student("Tishlee", 88),
                new Student("Anesu", 91), new Student("Rudo", 64), new Student("Nyasha", 81));
        double average = classList.stream().mapToInt(Student::marks).average().orElse(0);
        System.out.printf("Class average: %.1f%nStudents above average:%n", average);
        classList.stream().filter(student -> student.marks() > average).map(Student::name).sorted()
                .forEach(name -> System.out.println("  " + name));
    }
}
