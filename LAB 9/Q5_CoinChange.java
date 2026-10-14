/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 9, Challenge */
import java.util.ArrayList;
import java.util.List;

public class Q5_CoinChange {
    enum Coin {
        QUARTER(25), DIME(10), NICKEL(5), PENNY(1);
        final int cents; Coin(int cents) { this.cents = cents; }
    }
    static List<Coin> fewestCoins(int cents) {
        if (cents < 0) throw new IllegalArgumentException("Amount cannot be negative.");
        List<Coin> result = new ArrayList<>();
        for (Coin coin : Coin.values()) while (cents >= coin.cents) { result.add(coin); cents -= coin.cents; }
        return result;
    }
    public static void main(String[] args) {
        int cents = 87;
        List<Coin> change = fewestCoins(cents);
        System.out.println(cents + " cents can be returned as: " + change);
        System.out.println("Coin count: " + change.size());
    }
}
