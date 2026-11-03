package notification;

import org.example.Calculation;
import org.example.database.ISalaryDatabase;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.*;

class SalaryAlertTest {

    @Test
    void testNotificationTriggered(){
        ISalaryDatabase database = mock(ISalaryDatabase.class);
        Calculation calculation = new Calculation(database);
        INotification notification = mock(INotification.class);
        SalaryAlert salaryAlert = new SalaryAlert(calculation, notification);
        when(database.getSalaries()).thenReturn(List.of(1000000,2000000,20));
        salaryAlert.checkAndNotify();
        verify(notification).sendNotification();

    }

    @Test
    void testNotificationNotTriggered(){
        ISalaryDatabase database = mock(ISalaryDatabase.class);
        Calculation calculation = new Calculation(database);
        INotification notification = mock(INotification.class);
        SalaryAlert salaryAlert = new SalaryAlert(calculation, notification);
        when(database.getSalaries()).thenReturn(List.of(100,2000000,20));
        salaryAlert.checkAndNotify();
        verify(notification, never()).sendNotification();

    }


    @Test
    void testEmailTriggeredMock(){

        ISalaryDatabase database = mock(ISalaryDatabase.class);
        Calculation calculation = new Calculation(database);
        INotification notification = mock(EmailNotification.class);
        SalaryAlert salaryAlert = new SalaryAlert(calculation, notification);
        when(database.getSalaries()).thenReturn(List.of(1000000,2000000,20));
        salaryAlert.checkAndNotify();
        verify(notification).sendNotification();
    }
    @Test
    void testEmailTriggeredSpy(){
        // with spy, we are checking if the SendNotification really worked with email
        // without spy we can't really check behaviour of real objects
        // this is a problem, because we have to send real email as well
        ISalaryDatabase database = mock(ISalaryDatabase.class);
        Calculation calculation = new Calculation(database);
        INotification notification = spy(new EmailNotification("abc@gmail.ca"));
        SalaryAlert salaryAlert = new SalaryAlert(calculation, notification);
        when(database.getSalaries()).thenReturn(List.of(1000000,2000000,20));
        salaryAlert.checkAndNotify();
        verify(notification).sendNotification();

    }

    @Test
    void testEmailTriggeredSpyPartial(){
        // with spy, we are checking if the call really worked
        // without spy we can't really check behaviour of real objects
        // this time we don't send real emails, because we can control which part to ignore
        ISalaryDatabase database = mock(ISalaryDatabase.class);
        when(database.getSalaries()).thenReturn(List.of(1000000,2000000,20));
        Calculation calculation = new Calculation(database);
        INotification notification = spy(new EmailNotification("abc@gmail.ca"));
        doNothing().when(notification).sendNotification();
        SalaryAlert salaryAlert = new SalaryAlert(calculation, notification);
        salaryAlert.checkAndNotify();
        verify(notification).sendNotification();

    }


}