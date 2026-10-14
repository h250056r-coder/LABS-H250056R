/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 3, Basic 2 */
public class Q2_StudentGrades {
    static class Student {
        private final String name; private final int marks;
        Student(String name, int marks) {
            if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks outside 0..100");
            this.name = name; this.marks = marks;
        }
        String getGrade() {
            if (marks >= 80) return "A";
            if (marks >= 65) return "B";
            if (marks >= 50) return "C";
            return "F";
        }
    }
    public static void main(String[] args) {
        Student[] classList = { new Student("Tishlee", 86), new Student("Nyasha", 71), new Student("Kudzi", 48) };
        for (Student s : classList) System.out.println(s.name + " earned " + s.getGrade());
        System.out.println("The grade is calculated from marks, so no second field can become out of sync.");
    }
}
