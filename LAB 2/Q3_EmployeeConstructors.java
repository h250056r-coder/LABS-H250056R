/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 2, Intermediate 1 */
public class Q3_EmployeeConstructors {
    static class Employee {
        private static int nextId = 2500;
        final int employeeId;
        String name, department;
        Employee(String name, String department) { this.employeeId = nextId++; this.name = name; this.department = department; }
        Employee(String name) { this(name, "Student Services"); }
        Employee() { this("New colleague"); }
        Employee(Employee other) { this(other.name, other.department); }
        public String toString() { return "HIT-" + employeeId + " | " + name + " | " + department; }
    }
    public static void main(String[] args) {
        Employee first = new Employee("Tariro", "Computing");
        Employee[] staff = { first, new Employee("Rudo"), new Employee(), new Employee(first) };
        for (Employee employee : staff) System.out.println(employee);
    }
}
