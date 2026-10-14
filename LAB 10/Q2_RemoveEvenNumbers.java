/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 10, Basic 2 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Q2_RemoveEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(2, 5, 8, 11, 14, 17, 20, 23));
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Before: " + numbers);
        numbers.removeIf(isEven);
        System.out.println("After removing even values: " + numbers);
    }
}
