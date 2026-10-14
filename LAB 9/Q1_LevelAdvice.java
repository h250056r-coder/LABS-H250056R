/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 9, Basic 1 */
public class Q1_LevelAdvice {
    enum Level { LOW, MEDIUM, HIGH }
    static String advice(Level level) {
        return switch (level) {
            case LOW -> "Take it steadily and review your notes.";
            case MEDIUM -> "Make a short revision plan for this week.";
            case HIGH -> "Ask for help early and focus on one topic at a time.";
        };
    }
    public static void main(String[] args) {
        for (Level level : Level.values()) System.out.println(level + ": " + advice(level));
    }
}
