package Adapter_Pattern.AdapteeClasses;

public class Razorpay {
    public void makePayment(double amount){
        System.out.println("Processing Payment of "+amount + "through razorpay");
    }
}
