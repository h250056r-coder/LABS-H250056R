/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 2, Challenge */
public class Q5_TemperatureFactories {
    static final class Temperature {
        private final double celsius;
        private Temperature(double celsius) { this.celsius = celsius; }
        static Temperature fromCelsius(double value) { return new Temperature(value); }
        static Temperature fromFahrenheit(double value) { return new Temperature((value - 32) * 5 / 9); }
        double asCelsius() { return celsius; }
        double asFahrenheit() { return celsius * 9 / 5 + 32; }
    }
    public static void main(String[] args) {
        Temperature winterMorning = Temperature.fromCelsius(12);
        Temperature warmAfternoon = Temperature.fromFahrenheit(77);
        System.out.printf("Morning: %.1f°C; afternoon: %.1f°C%n", winterMorning.asCelsius(), warmAfternoon.asCelsius());
        System.out.println("Named factories make the input unit clear at the call site.");
    }
}
