/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 3, Intermediate 1 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3_AccountHistory {
    static class BankAccount {
        private final List<String> history = new ArrayList<>();
        private double balance;
        BankAccount(double opening) { if (opening < 0) throw new IllegalArgumentException(); balance = opening; history.add("Opened with " + opening); }
        void deposit(double amount) { if (amount <= 0) throw new IllegalArgumentException(); balance += amount; history.add("Deposit +" + amount); }
        boolean withdraw(double amount) {
            if (amount <= 0) throw new IllegalArgumentException();
            if (amount > balance) { history.add("Declined withdrawal " + amount); return false; }
            balance -= amount; history.add("Withdrawal -" + amount); return true;
        }
        List<String> getTransactionHistory() { return Collections.unmodifiableList(new ArrayList<>(history)); }
        double getBalance() { return balance; }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(120);
        account.deposit(35); account.withdraw(20); account.withdraw(500);
        System.out.println("Account activity:");
        for (String line : account.getTransactionHistory()) System.out.println("  • " + line);
        System.out.printf("Available balance: $%.2f%n", account.getBalance());
    }
}
