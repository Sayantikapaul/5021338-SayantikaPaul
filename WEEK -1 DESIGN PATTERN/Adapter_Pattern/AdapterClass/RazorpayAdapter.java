package Adapter_Pattern.AdapterClass;

import Adapter_Pattern.AdapteeClasses.Razorpay;
import Adapter_Pattern.PaymentProcessor.paymentProcessor;

public class RazorpayAdapter implements paymentProcessor {
    private Razorpay razorpay;

    public RazorpayAdapter(Razorpay razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public void processPayment(double amount) {
        razorpay.makePayment(amount);
    }
}
