interface PaymentProcessor {
    void processPayment(double amount);
}
class PayPalGateway {

    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " made using PayPal.");
    }
}
class StripeGateway {

    public void payAmount(double amount) {
        System.out.println("Payment of Rs." + amount + " made using Stripe.");
    }
}
class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway paypal;

    public PayPalAdapter() {
        paypal = new PayPalGateway();
    }
    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}
class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripe;

    public StripeAdapter() {
        stripe = new StripeGateway();
    }

    @Override
    public void processPayment(double amount) {
        stripe.payAmount(amount);
    }
}
public class AdapterPatternExample {

    public static void main(String[] args) {

        PaymentProcessor payment1 = new PayPalAdapter();
        payment1.processPayment(1000);

        PaymentProcessor payment2 = new StripeAdapter();
        payment2.processPayment(2500);
    }
}