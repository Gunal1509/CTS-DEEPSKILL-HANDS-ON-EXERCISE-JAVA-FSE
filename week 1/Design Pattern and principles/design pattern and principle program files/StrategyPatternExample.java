interface PaymentStrategy {
    void pay(double amount);
}
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal.");
    }
}
class PaymentContext {
    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void makePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
public class StrategyPatternExample {

    public static void main(String[] args) {

        PaymentContext payment = new PaymentContext();
        payment.setPaymentStrategy(new CreditCardPayment());
        payment.makePayment(1000);
        payment.setPaymentStrategy(new PayPalPayment());
        payment.makePayment(2500);
    }
}