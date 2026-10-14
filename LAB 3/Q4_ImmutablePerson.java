/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 3, Intermediate 2 */
public class Q4_ImmutablePerson {
    static final class ImmutablePerson {
        private final String name;
        private final int age;
        ImmutablePerson(String name, int age) {
            if (name == null || name.isBlank() || age < 0) throw new IllegalArgumentException("Name and a non-negative age are required.");
            this.name = name.trim(); this.age = age;
        }
        String getName() { return name; }
        int getAge() { return age; }
        public String toString() { return name + ", age " + age; }
    }
    public static void main(String[] args) {
        ImmutablePerson person = new ImmutablePerson("Tishlee Mvududu", 20);
        System.out.println(person);
        System.out.println("final class prevents subclasses; final private fields and no setters keep its values fixed.");
    }
}
