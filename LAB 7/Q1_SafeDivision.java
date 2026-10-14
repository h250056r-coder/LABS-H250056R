/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 7, Basic 1 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1_SafeDivision {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("First whole number: "); int first = input.nextInt();
            System.out.print("Second whole number: "); int second = input.nextInt();
            System.out.println("Answer: " + (first / second));
        } catch (InputMismatchException ex) {
            System.out.println("Please enter whole numbers only.");
        } catch (ArithmeticException ex) {
            System.out.println("A number cannot be divided by zero.");
        }
    }
}
