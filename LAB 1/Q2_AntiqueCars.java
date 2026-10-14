/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 1, Basic 2 */
import java.time.Year;

public class Q2_AntiqueCars {
    static class Car {
        private final String brand;
        private final int year;

        Car(String brand, int year) { this.brand = brand; this.year = year; }
        boolean isAntique() { return Year.now().getValue() - year > 25; }
        void display() {
            System.out.printf("%s (%d) — antique: %s%n", brand, year, isAntique());
        }
    }

    public static void main(String[] args) {
        System.out.println("CLASSIC CAR CHECK  /  Tishlee Mvududu");
        new Car("Mercedes-Benz 190E", 1992).display();
        new Car("Mercedes-Benz A-Class", 2019).display();
    }
}
