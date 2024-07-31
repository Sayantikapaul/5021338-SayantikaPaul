package Decorator_Pattern;
import Decorator_Pattern.NotifierDecorator;
public abstract class NotifierDecorator implements Notifer {
    public Notifer wrappedNotifier;

    public NotifierDecorator(Notifer notifer){
        this.wrappedNotifier = notifer;
    }

    public void send(String message){ 
        wrappedNotifier.send(message);
        sendSMS(message);
    }

    public void sendSMS(String message) {
        System.out.println("SENDING SMS  :" +message);
    }
}
