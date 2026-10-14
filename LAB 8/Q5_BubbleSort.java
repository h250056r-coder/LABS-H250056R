/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 8, Challenge */
import java.util.Arrays;

public class Q5_BubbleSort {
    static <T extends Comparable<T>> void bubbleSort(T[] values) {
        for (int pass = 0; pass < values.length - 1; pass++) {
            boolean changed = false;
            for (int i = 0; i < values.length - 1 - pass; i++) {
                if (values[i].compareTo(values[i + 1]) > 0) {
                    T swap = values[i]; values[i] = values[i + 1]; values[i + 1] = swap; changed = true;
                }
            }
            if (!changed) break;
        }
    }
    public static void main(String[] args) {
        Integer[] scores = { 87, 63, 99, 74 }; String[] names = { "Rudo", "Anesu", "Tishlee" };
        bubbleSort(scores); bubbleSort(names);
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Names:  " + Arrays.toString(names));
        System.out.println("int[] cannot be used because generics work with reference types; Integer[] is the wrapper type.");
    }
}
