/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 1, Intermediate 1 */
public class Q3_LargestRectangle {
    static class Rectangle {
        final double width, height;
        Rectangle(double width, double height) { this.width = width; this.height = height; }
        double area() { return width * height; }
        double perimeter() { return 2 * (width + height); }
    }

    public static void main(String[] args) {
        Rectangle[] samples = { new Rectangle(3, 4), new Rectangle(5, 7),
                new Rectangle(8, 2), new Rectangle(6, 6), new Rectangle(2.5, 9) };
        Rectangle largest = samples[0];
        for (Rectangle rectangle : samples) if (rectangle.area() > largest.area()) largest = rectangle;
        System.out.println("HIT design studio — rectangle with the largest area");
        System.out.printf("%.1f by %.1f | area %.1f | perimeter %.1f%n",
                largest.width, largest.height, largest.area(), largest.perimeter());
    }
}
