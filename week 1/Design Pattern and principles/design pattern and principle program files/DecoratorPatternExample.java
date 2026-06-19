interface Notifier {
    void send(String message);
}
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}
abstract class NotifierDecorator implements Notifier {
protected Notifier notifier;
public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
}
class SMSNotifierDecorator extends NotifierDecorator {
public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        notifier.send(message);
        System.out.println("SMS Notification: " + message);
    }
}
class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        notifier.send(message);
        System.out.println("Slack Notification: " + message);
    }
}
public class DecoratorPatternExample {

    public static void main(String[] args) {
        Notifier email = new EmailNotifier();
        email.send("Server Started");
        System.out.println();
        Notifier emailSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailSMS.send("Payment Successful");
        System.out.println();
        Notifier allNotifications =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));
        allNotifications.send("System Error");
    }
}