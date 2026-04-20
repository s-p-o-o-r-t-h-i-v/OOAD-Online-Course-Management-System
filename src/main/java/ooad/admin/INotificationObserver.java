package ooad.admin;

// Observer interface (Observer Pattern)
public interface INotificationObserver {
    void onNotificationSent(String title, String message, String sentTo);
}