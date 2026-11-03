package notification;

public class Notify {
    INotification notification;
    public Notify (INotification notification){
        this.notification = notification;
    }
    public void notifyUser(){
        notification.sendNotification();
    }
}
