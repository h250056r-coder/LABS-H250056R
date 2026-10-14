/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 5, Intermediate 1 */
public class Q3_InternPayroll {
    static class Employee {
        final String name; final double salary;
        Employee(String name, double salary) { this.name = name; this.salary = salary; }
        double calculatePay() { return salary; }
    }
    static class Manager extends Employee {
        final double bonus;
        Manager(String n, double s, double b) { super(n, s); bonus = b; }
        @Override double calculatePay() { return salary + bonus; }
    }
    static class Developer extends Employee {
        final int overtimeHours;
        Developer(String n, double s, int h) { super(n, s); overtimeHours = h; }
        @Override double calculatePay() { return salary + overtimeHours * 25; }
    }
    static class Intern extends Employee {
        Intern(String n, double stipend) { super(n, stipend); }
        @Override double calculatePay() { return salary; }
    }
    public static void main(String[] args) {
        Employee[] team = { new Manager("Nyasha", 3500, 800), new Developer("Tapiwa", 3000, 10), new Intern("Tishlee", 450) };
        double total = 0;
        for (Employee employee : team) { System.out.printf("%-10s $%.2f%n", employee.name, employee.calculatePay()); total += employee.calculatePay(); }
        System.out.printf("Payroll total: $%.2f%n", total);
    }
}
