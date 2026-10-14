/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 8, Intermediate 2 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q4_WordFrequency {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter a short paragraph:");
            String paragraph = input.nextLine().toLowerCase().replaceAll("[^\\p{L}\\p{N}']+", " ").trim();
            Map<String, Integer> counts = new HashMap<>();
            if (!paragraph.isEmpty()) for (String word : paragraph.split("\\s+")) counts.merge(word, 1, Integer::sum);
            counts.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry -> System.out.printf("%-15s %d%n", entry.getKey(), entry.getValue()));
        }
    }
}
