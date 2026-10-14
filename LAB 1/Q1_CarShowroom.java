/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 1, Basic 1 */
public class Q1_CarShowroom {
    static class Car {
        String brand;
        int year;
        double mileage;

        Car(String brand, int year, double mileage) {
            this.brand = brand;
            this.year = year;
            this.mileage = mileage;
        }

        void display() {
            System.out.printf("%-12s | %d | %,8.1f km%n", brand, year, mileage);
        }
    }

    public static void main(String[] args) {
        System.out.println("Tishlee'S LITTLE SHOWROOM  /  Harare");
        System.out.println("--------------------------------------");
        Car[] cars = { new Car("Mercedes-Benz", 2021, 28400),
                       new Car("Toyota", 2018, 71350),
                       new Car("Honda", 2020, 39620) };
        for (Car car : cars) car.display();
    }
}
