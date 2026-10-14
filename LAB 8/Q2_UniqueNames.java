/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 8, Basic 2 */
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Q2_UniqueNames {
    public static void main(String[] args) {
        List<String> names = List.of("Tishlee", "Tariro", "Tishlee", "Anesu", "Tariro", "Rudo");
        Set<String> unique = new LinkedHashSet<>(names); // LinkedHashSet keeps the first-seen order
        System.out.println("Names from the class list: " + names);
        System.out.println("After removing repeats:   " + unique);
    }
}
