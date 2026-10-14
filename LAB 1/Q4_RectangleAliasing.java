/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 1, Intermediate 2 */
public class Q4_RectangleAliasing {
    static class Rectangle { double width, height; Rectangle(double w, double h) { width = w; height = h; } }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 6);
        Rectangle r2 = r1;             // both variables refer to the same rectangle
        r2.width = 12;
        System.out.println("r1.width = " + r1.width);
        System.out.println("Reason: assigning r1 to r2 copied its reference, so the change is shared.");
    }
}
