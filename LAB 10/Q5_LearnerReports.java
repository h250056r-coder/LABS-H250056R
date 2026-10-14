/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 10, Challenge */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q5_LearnerReports {
    record Learner(String name, int mark) {
        String band() { return mark >= 80 ? "A" : mark >= 65 ? "B" : "C"; }
    }
    public static void main(String[] args) {
        Path input = Path.of("learners.csv");
        try {
            List<Learner> learners = Files.readAllLines(input).stream().skip(1).filter(line -> !line.isBlank())
                    .map(line -> line.split(",", 2)).map(parts -> new Learner(parts[0].trim(), Integer.parseInt(parts[1].trim()))).toList();
            Map<String, List<Learner>> byBand = learners.stream().collect(Collectors.groupingBy(Learner::band));
            for (String band : List.of("A", "B", "C")) {
                List<String> report = byBand.getOrDefault(band, List.of()).stream()
                        .map(learner -> learner.name() + "," + learner.mark()).toList();
                Path output = Path.of("grade_" + band + "_report.txt");
                Files.write(output, report);
                System.out.printf("Grade %s: %d learner(s) -> %s%n", band, report.size(), output);
            }
        } catch (IOException | RuntimeException ex) {
            System.out.println("Could not build reports. Check learners.csv (name,mark) and try again. " + ex.getMessage());
        }
    }
}
