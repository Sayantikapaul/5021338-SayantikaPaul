package Adapter_Pattern.AdapterPatternExample;

import Adapter_Pattern.AdapterClass.PaypalAdapter;
import Adapter_Pattern.AdapterClass.RazorpayAdapter;
import Adapter_Pattern.AdapteeClasses.Paypal;
import Adapter_Pattern.AdapteeClasses.Razorpay;
import Adapter_Pattern.PaymentProcessor.paymentProcessor;

public class AdapterPatternExample {
    public static void main(String[] args) {
        paymentProcessor paypalProcessor = new PaypalAdapter(new Paypal());
        paypalProcessor.processPayment(1000);

        paymentProcessor razorpayProcessor = new RazorpayAdapter(new Razorpay());
        razorpayProcessor.processPayment(1200);
    }
}
