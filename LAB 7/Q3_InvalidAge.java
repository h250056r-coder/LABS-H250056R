/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 7, Intermediate 1 */
public class Q3_InvalidAge {
    static class InvalidAgeException extends Exception {
        InvalidAgeException(String message) { super(message); }
    }
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) throw new InvalidAgeException("Age must be between 0 and 120.");
        System.out.println("Age accepted: " + age);
    }
    public static void main(String[] args) {
        for (int age : new int[] { 20, -2, 130 }) {
            try { validateAge(age); }
            catch (InvalidAgeException ex) { System.out.println("Rejected: " + ex.getMessage()); }
        }
    }
}
