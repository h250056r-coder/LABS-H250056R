/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 3, Challenge */
public class Q5_KelvinTemperature {
    static final class Temperature {
        private final double kelvin;
        Temperature(double kelvin) {
            if (kelvin < 0) throw new IllegalArgumentException("Temperature cannot be below absolute zero.");
            this.kelvin = kelvin;
        }
        double getCelsius() { return kelvin - 273.15; }
        double getFahrenheit() { return getCelsius() * 9 / 5 + 32; }
    }
    public static void main(String[] args) {
        Temperature lab = new Temperature(298.15);
        System.out.printf("Reading: %.1f°C / %.1f°F%n", lab.getCelsius(), lab.getFahrenheit());
        try { new Temperature(-1); } catch (IllegalArgumentException ex) { System.out.println(ex.getMessage()); }
        System.out.println("Callers use the same getters even if storage changes from kelvin later.");
    }
}
