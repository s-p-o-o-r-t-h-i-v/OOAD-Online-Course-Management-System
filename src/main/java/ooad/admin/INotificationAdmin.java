package ooad.admin;

import ooad.model.Notification;
import java.util.List;

// ISP: only notification methods here
public interface INotificationAdmin {
    void sendNotification(String title, String message, String sentTo);
    List<Notification> getAllNotifications();
}