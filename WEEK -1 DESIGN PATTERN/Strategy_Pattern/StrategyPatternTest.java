package Strategy_Pattern;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Paying with Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/23");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(250.00);

        // Paying with PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(300.00);
    }
}
