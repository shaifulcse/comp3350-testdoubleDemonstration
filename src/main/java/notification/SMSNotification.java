package notification;

public class SMSNotification implements INotification{

    String phoneNumber;
    public SMSNotification(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void sendNotification() {
        System.out.println("Sending notification to " + phoneNumber);
    }
}
