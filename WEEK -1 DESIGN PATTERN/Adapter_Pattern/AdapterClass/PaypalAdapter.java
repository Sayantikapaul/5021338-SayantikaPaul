package Adapter_Pattern.AdapterClass;

import Adapter_Pattern.AdapteeClasses.Paypal;
import Adapter_Pattern.PaymentProcessor.paymentProcessor;

public class PaypalAdapter implements paymentProcessor {
    private Paypal paypal;

    public PaypalAdapter(Paypal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}
