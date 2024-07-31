package Strategy_Pattern;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String name, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}