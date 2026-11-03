package notification;

public class EmailNotification implements INotification{

    String emailAddress;
    EmailNotification(String emailAddress) throws IllegalArgumentException{
        checkValidEmail(emailAddress);
        this.emailAddress = emailAddress;
    }
    @Override
    public void sendNotification() {
          // use third party library and complex code
           System.out.println("Sending email to "+ emailAddress);
    }

    private void checkValidEmail(String email){
        if (!email.contains("@") || !email.endsWith(".ca")){ // just a fake check..
            throw new IllegalArgumentException();
        }
    }

}
