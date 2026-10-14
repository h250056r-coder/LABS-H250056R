/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 10, Intermediate 1 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Q3_TextFileStats {
    public static void main(String[] args) {
        Path file = args.length == 0 ? Path.of("Tishlee_lab_notes.txt") : Path.of(args[0]);
        try {
            List<String> lines = Files.readAllLines(file);
            long words = lines.stream().flatMap(line -> java.util.Arrays.stream(line.trim().split("\\s+")))
                    .filter(word -> !word.isBlank()).count();
            long characters = lines.stream().mapToLong(String::length).sum();
            System.out.printf("File: %s%nLines: %d%nWords: %d%nCharacters (excluding line breaks): %d%n",
                    file, lines.size(), words, characters);
        } catch (IOException ex) { System.out.println("Could not read " + file + ": " + ex.getMessage()); }
    }
}
