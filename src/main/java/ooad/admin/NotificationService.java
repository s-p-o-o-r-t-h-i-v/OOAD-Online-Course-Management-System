package ooad.admin;

import ooad.model.Notification;
import ooad.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// ISP: implements only INotificationAdmin
// Observer Pattern: acts as Subject — notifies all observers when a notification is sent
@Service
public class NotificationService implements INotificationAdmin {

    private final NotificationRepository notificationRepository;

    // Observer list (Observer Pattern)
    private final List<INotificationObserver> observers = new ArrayList<>();

    public NotificationService(NotificationRepository notificationRepository,
            EmailNotificationObserver emailObserver,
            DashboardObserver dashboardObserver) {
        this.notificationRepository = notificationRepository;
        // Register observers
        observers.add(emailObserver);
        observers.add(dashboardObserver);
    }

    // Notify all registered observers
    private void notifyObservers(String title, String message, String sentTo) {
        for (INotificationObserver observer : observers) {
            observer.onNotificationSent(title, message, sentTo);
        }
    }

    @Override
    public void sendNotification(String title, String message, String sentTo) {
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setSentTo(sentTo);
        notificationRepository.save(notification);

        // Trigger all observers
        notifyObservers(title, message, sentTo);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}