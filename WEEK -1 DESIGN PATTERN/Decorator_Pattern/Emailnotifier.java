package Decorator_Pattern;

public class Emailnotifier implements Notifer {

    @Override
    public void send(String message) {
        System.out.println("Sending Email : "+message);
    }
    
}
