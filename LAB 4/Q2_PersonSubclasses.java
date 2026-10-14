/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 4, Basic 2 */
public class Q2_PersonSubclasses {
    static class Person {
        private final String name; private final int age;
        Person(String name, int age) { this.name = name; this.age = age; }
        void display() { System.out.printf("%s, age %d%n", name, age); }
    }
    static class Student extends Person {
        Student(String name, int age) { super(name, age); }
        void attendLecture() { System.out.println("Student is heading to the OOP lecture."); }
    }
    static class Teacher extends Person {
        Teacher(String name, int age) { super(name, age); }
        void teach() { System.out.println("Teacher is preparing the lab."); }
    }
    public static void main(String[] args) {
        Student s = new Student("Tishlee", 20); Teacher t = new Teacher("Mrs Moyo", 42);
        s.display(); s.attendLecture(); t.display(); t.teach();
    }
}
