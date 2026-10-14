/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 3, Basic 1 */
public class Q1_StudentMarks {
    static class Student {
        private String name;
        private int marks;
        Student(String name, int marks) { this.name = name; setMarks(marks); }
        void setMarks(int marks) {
            if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks must be from 0 to 100.");
            this.marks = marks;
        }
        int getMarks() { return marks; }
        String getName() { return name; }
    }
    public static void main(String[] args) {
        Student student = new Student("Tishlee Mvududu", 86);
        System.out.println(student.getName() + " — " + student.getMarks() + "/100");
        try { student.setMarks(108); } catch (IllegalArgumentException ex) { System.out.println("Update declined: " + ex.getMessage()); }
    }
}
