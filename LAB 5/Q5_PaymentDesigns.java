/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 5, Challenge */
public class Q5_PaymentDesigns {
    interface Payment { double amount(); }
    static class CardPayment implements Payment {
        private final double value; CardPayment(double v) { value = v; }
        public double amount() { return value; }
        void chargeCard() { System.out.printf("Charged card: $%.2f%n", value); }
    }
    static class MobileMoneyPayment implements Payment {
        private final double value; MobileMoneyPayment(double v) { value = v; }
        public double amount() { return value; }
        void sendEcoCash() { System.out.printf("Sent mobile money: $%.2f%n", value); }
    }
    static class PatternMatchingProcessor {
        void pay(Payment p) {
            if (p instanceof CardPayment card) card.chargeCard();
            else if (p instanceof MobileMoneyPayment mobile) mobile.sendEcoCash();
            else throw new IllegalArgumentException("Unsupported payment");
        }
    }
    interface ProcessablePayment extends Payment { void process(); }
    static class Card implements ProcessablePayment {
        private final double value; Card(double v) { value = v; }
        public double amount() { return value; }
        public void process() { System.out.printf("Charged card: $%.2f%n", value); }
    }
    static class MobileMoney implements ProcessablePayment {
        private final double value; MobileMoney(double v) { value = v; }
        public double amount() { return value; }
        public void process() { System.out.printf("Sent mobile money: $%.2f%n", value); }
    }
    static class PolymorphicProcessor { void pay(ProcessablePayment p) { p.process(); } }
    public static void main(String[] args) {
        System.out.println("Pattern matching processor:");
        PatternMatchingProcessor checks = new PatternMatchingProcessor(); checks.pay(new CardPayment(25)); checks.pay(new MobileMoneyPayment(8));
        System.out.println("Polymorphic processor:");
        PolymorphicProcessor common = new PolymorphicProcessor(); common.pay(new Card(25)); common.pay(new MobileMoney(8));
        System.out.println("The polymorphic version lets each payment own its steps; adding a type does not add another processor branch.");
    }
}
