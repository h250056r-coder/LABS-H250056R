/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 6, Basic 1 */
public class Q1_AbstractShapes {
    abstract static class Shape { abstract double area(); abstract double perimeter(); }
    static class Circle extends Shape {
        final double r; Circle(double r) { this.r = r; }
        double area() { return Math.PI * r * r; } double perimeter() { return 2 * Math.PI * r; }
    }
    static class Rectangle extends Shape {
        final double w, h; Rectangle(double w, double h) { this.w = w; this.h = h; }
        double area() { return w * h; } double perimeter() { return 2 * (w + h); }
    }
    static class Square extends Rectangle { Square(double side) { super(side, side); } }
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(3), new Rectangle(4, 7), new Square(5) };
        for (Shape shape : shapes) System.out.printf("%-10s area %.2f | perimeter %.2f%n", shape.getClass().getSimpleName(), shape.area(), shape.perimeter());
    }
}
