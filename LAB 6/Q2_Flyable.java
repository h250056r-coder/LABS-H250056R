/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 6, Basic 2 */
public class Q2_Flyable {
    interface Flyable { void fly(); }
    static class Bird implements Flyable { public void fly() { System.out.println("A weaver bird flutters over the garden."); } }
    static class Aeroplane implements Flyable { public void fly() { System.out.println("A plane climbs above Harare."); } }
    public static void main(String[] args) {
        Flyable[] flyers = { new Bird(), new Aeroplane() };
        for (Flyable flyer : flyers) flyer.fly();
    }
}
