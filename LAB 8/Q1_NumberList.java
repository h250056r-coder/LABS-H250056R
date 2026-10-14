/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 8, Basic 1 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1_NumberList {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>(List.of(72, 86, 91, 64, 78, 88, 53, 95, 81, 69));
        int sum = 0, maximum = marks.get(0);
        for (int mark : marks) { sum += mark; if (mark > maximum) maximum = mark; }
        System.out.println("Marks: " + marks);
        System.out.println("Sum: " + sum + " | maximum: " + maximum);
        List<Integer> backwards = new ArrayList<>(marks); Collections.reverse(backwards);
        System.out.println("Reverse order: " + backwards);
    }
}
