/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 10, Basic 1 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1_SaveAndReadLines {
    public static void main(String[] args) {
        Path file = Path.of("Tishlee_lab_notes.txt");
        List<String> lines = new ArrayList<>();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Type five short lines for your lab notebook:");
            for (int i = 1; i <= 5; i++) { System.out.print(i + "> "); lines.add(input.nextLine()); }
        }
        try {
            Files.write(file, lines);
            System.out.println("Saved to " + file.toAbsolutePath());
            System.out.println("Reading the lines back:");
            for (String line : Files.readAllLines(file)) System.out.println("  " + line);
        } catch (IOException ex) { System.out.println("Could not use the notes file: " + ex.getMessage()); }
    }
}
