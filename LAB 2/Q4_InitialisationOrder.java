/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 2, Intermediate 2 */
public class Q4_InitialisationOrder {
    static { System.out.println("Static block one"); }
    static { System.out.println("Static block two"); }
    { System.out.println("Instance block one"); }
    { System.out.println("Instance block two"); }
    Q4_InitialisationOrder() { System.out.println("Constructor"); }
    public static void main(String[] args) {
        System.out.println("-- first object --"); new Q4_InitialisationOrder();
        System.out.println("-- second object --"); new Q4_InitialisationOrder();
        System.out.println("Static blocks run once; instance blocks run for each new object, in source order.");
    }
}
