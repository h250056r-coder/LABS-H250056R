/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 5, Basic 2 */
public class Q2_AnimalSounds {
    static class Animal { String sound() { return "..."; } }
    static class Cat extends Animal { @Override String sound() { return "Meow"; } }
    static class Cow extends Animal { @Override String sound() { return "Moo"; } }
    static class Duck extends Animal { @Override String sound() { return "Quack"; } }
    public static void main(String[] args) {
        Animal[] pets = { new Cat(), new Cow(), new Duck() };
        for (Animal pet : pets) System.out.println(pet.getClass().getSimpleName() + " says " + pet.sound());
    }
}
