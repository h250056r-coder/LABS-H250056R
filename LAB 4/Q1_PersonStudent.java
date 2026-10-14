/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 4, Basic 1 */
public class Q1_PersonStudent {
    static class Person {
        protected final String name; protected final int age;
        Person(String name, int age) { this.name = name; this.age = age; }
        void display() { System.out.println(name + " is " + age + " years old."); }
    }
    static class Student extends Person {
        private final String course;
        Student(String name, int age, String course) { super(name, age); this.course = course; }
        @Override void display() { super.display(); System.out.println("Course: " + course); }
    }
    public static void main(String[] args) { new Student("Tishlee Mvududu", 20, "Software Engineering").display(); }
}
