/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 2, Basic 1 */
public class Q1_CircleConstructors {
    static class Circle {
        final double radius;
        Circle(double radius) { this.radius = radius; }
        Circle() { this(1.0); }
        double area() { return Math.PI * radius * radius; }
    }
    public static void main(String[] args) {
        Circle custom = new Circle(4.5), defaultCircle = new Circle();
        System.out.printf("Custom circle r=%.1f, area=%.2f%n", custom.radius, custom.area());
        System.out.printf("Default circle r=%.1f, area=%.2f%n", defaultCircle.radius, defaultCircle.area());
    }
}
