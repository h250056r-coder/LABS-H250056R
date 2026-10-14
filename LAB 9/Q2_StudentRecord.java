/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 9, Basic 2 */
public class Q2_StudentRecord {
    record Student(String name, int age) { }
    public static void main(String[] args) {
        Student first = new Student("Tishlee Mvududu", 20);
        Student second = new Student("Tishlee Mvududu", 20);
        System.out.println(first);
        System.out.println("Same value? " + first.equals(second));
        System.out.println("Name component: " + first.name());
    }
}
