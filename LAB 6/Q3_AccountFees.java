/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 6, Intermediate 1 */
public class Q3_AccountFees {
    abstract static class Account {
        private double balance;
        Account(double opening) { deposit(opening); }
        void deposit(double amount) { if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive"); balance += amount; }
        double getBalance() { return balance; }
        abstract double monthlyFee();
    }
    static class SavingsAccount extends Account { SavingsAccount(double n) { super(n); } double monthlyFee() { return 2.50; } }
    static class CurrentAccount extends Account { CurrentAccount(double n) { super(n); } double monthlyFee() { return 5.00; } }
    public static void main(String[] args) {
        Account[] accounts = { new SavingsAccount(150), new CurrentAccount(400) };
        for (Account account : accounts) System.out.printf("%s balance $%.2f, monthly fee $%.2f%n", account.getClass().getSimpleName(), account.getBalance(), account.monthlyFee());
    }
}
