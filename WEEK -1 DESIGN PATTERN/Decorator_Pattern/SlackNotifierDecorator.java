package Decorator_Pattern;
import Decorator_Pattern.NotifierDecorator;
public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifer smsNotifier) {
        super(smsNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}