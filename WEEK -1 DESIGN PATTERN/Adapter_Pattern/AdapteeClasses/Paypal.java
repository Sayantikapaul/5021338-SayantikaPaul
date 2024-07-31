package Adapter_Pattern.AdapteeClasses;

public class Paypal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}
