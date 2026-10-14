/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 4, Intermediate 1 */
public class Q3_VehicleConstructorChain {
    static class Vehicle { Vehicle(String name) { System.out.println("Vehicle: " + name); } }
    static class Car extends Vehicle { Car(String name) { super(name); System.out.println("Car setup"); } }
    static class ElectricCar extends Car {
        ElectricCar(String name) { super(name); System.out.println("Electric battery setup"); }
    }
    public static void main(String[] args) {
        System.out.println("Starting the chain from the most general class:");
        new ElectricCar("Tishlee's electric Mercedes");
    }
}
