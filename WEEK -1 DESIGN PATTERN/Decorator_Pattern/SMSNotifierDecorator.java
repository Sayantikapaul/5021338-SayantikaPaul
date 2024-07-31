package Decorator_Pattern;
import Decorator_Pattern.NotifierDecorator;
public class SMSNotifierDecorator extends NotifierDecorator{
    
    public SMSNotifierDecorator(Notifer notifer) { 
        super(notifer);
    }

    @Override
    public void send(String message) {
        super.send(message);

    }

    
}
