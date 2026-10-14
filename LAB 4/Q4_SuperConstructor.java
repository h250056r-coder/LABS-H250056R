/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 4, Intermediate 2 */
public class Q4_SuperConstructor {
    static class Animal {
        final String name;
        Animal(String name) { this.name = name; }
    }
    static class Dog extends Animal {
        Dog(String name) { super(name); }
    }
    // If Dog's constructor omitted super(name), Java would try super() automatically.
    // Animal has no Animal(), so that implicit call causes a compile-time error.
    public static void main(String[] args) { System.out.println(new Dog("Poppy").name + " the dog"); }
}
