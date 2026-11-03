package org.example.notification;
import org.example.Calculation;

public class SalaryAlert {

    static final int THRESHOLD = 2;

    private final Calculation calculation;
    private final INotification notification;

    public SalaryAlert(Calculation calculation, INotification notification) {
        this.calculation = calculation;
        this.notification = notification;
    }

    public void checkAndNotify() {
        int highSalaryCount = calculation.calSalary();
        if (highSalaryCount >= THRESHOLD) {
            notification.sendNotification();
        }
    }
}