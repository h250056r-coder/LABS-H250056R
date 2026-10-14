/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 7, Challenge */
public class Q5_FinallyRuns {
    static int calculate() {
        try { System.out.println("Returning from try"); return 7; }
        finally { System.out.println("Finally runs before calculate() returns"); }
    }
    public static void main(String[] args) {
        int answer = calculate();
        System.out.println("Caller received " + answer);
        System.out.println("The return value is saved, then finally executes before control reaches the caller.");
    }
}
