/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 5, Basic 1 */
import java.util.Arrays;

public class Q1_PrintOverloads {
    static void print(int value) { System.out.println("Integer: " + value); }
    static void print(double value) { System.out.printf("Decimal: %.2f%n", value); }
    static void print(String value) { System.out.println("Text: " + value); }
    static void print(int[] values) { System.out.println("Marks: " + Arrays.toString(values)); }
    public static void main(String[] args) {
        print(21); print(86.5); print("HIT Software Engineering"); print(new int[] { 78, 86, 91 });
    }
}
