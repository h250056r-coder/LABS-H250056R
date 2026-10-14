/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 5, Intermediate 2 */
public class Q4_MethodsAndFields {
    static class Vehicle {
        String label = "Vehicle";
        String describe() { return "general transport"; }
    }
    static class Mercedes extends Vehicle {
        String label = "Mercedes";
        @Override String describe() { return "a Mercedes on the road"; }
    }
    public static void main(String[] args) {
        Vehicle ride = new Mercedes();
        System.out.println("Field: " + ride.label);
        System.out.println("Method: " + ride.describe());
        System.out.println("Fields use the declared reference type; overridden methods use the actual object's type.");
    }
}
