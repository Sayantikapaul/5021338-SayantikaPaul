package Decorator_Pattern;
import Decorator_Pattern.Notifer;
public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifer emailNotifier = new Emailnotifier();
        Notifer smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifer slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notifications via Email, SMS, and Slack
        slackNotifier.send("Hello, this is a test notification!");
    }
}
