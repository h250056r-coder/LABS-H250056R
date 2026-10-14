/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 1, Challenge */
public class Q5_PersonAddress {
    static class Address { String city; Address(String city) { this.city = city; } }
    static class Person { String name; Address address; Person(String n, Address a) { name = n; address = a; } }

    public static void main(String[] args) {
        Person Tishlee = new Person("Tishlee", new Address("Harare"));
        System.out.println(Tishlee.name + " lives in " + Tishlee.address.city);
        Person newStudent = new Person("Tariro", null);
        try {
            System.out.println(newStudent.address.city);
        } catch (NullPointerException ex) {
            System.out.println("No address is stored for " + newStudent.name + "; a null dereference throws NullPointerException.");
        }
    }
}
