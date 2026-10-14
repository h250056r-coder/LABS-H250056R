/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 2, Basic 2 */
public class Q2_CircleCounter {
    static class Circle {
        private static int count;
        private final double radius;
        Circle(double radius) { this.radius = radius; count++; }
        static int getCount() { return count; }
        double area() { return Math.PI * radius * radius; }
    }
    public static void main(String[] args) {
        new Circle(1); new Circle(3.5); new Circle(6);
        System.out.println("Circles created in this run: " + Circle.getCount());
    }
}
