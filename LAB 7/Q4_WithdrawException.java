/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 7, Intermediate 2 */
public class Q4_WithdrawException {
    static class InsufficientFundsException extends Exception {
        InsufficientFundsException(String message) { super(message); }
    }
    static class BankAccount {
        private double balance;
        BankAccount(double opening) { if (opening < 0) throw new IllegalArgumentException(); balance = opening; }
        void deposit(double amount) { if (amount <= 0) throw new IllegalArgumentException(); balance += amount; }
        void withdraw(double amount) throws InsufficientFundsException {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive.");
            if (amount > balance) throw new InsufficientFundsException("Requested $" + amount + ", available $" + balance);
            balance -= amount;
        }
        double getBalance() { return balance; }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(75);
        try { account.withdraw(100); }
        catch (InsufficientFundsException ex) { System.out.println("Withdrawal declined: " + ex.getMessage()); }
        System.out.printf("Balance stays at $%.2f%n", account.getBalance());
        System.out.println("A checked exception makes the caller handle the declined withdrawal; a boolean is simpler when it is an expected everyday result.");
    }
}
