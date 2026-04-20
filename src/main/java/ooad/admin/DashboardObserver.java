package ooad.admin;

import org.springframework.stereotype.Component;

// Concrete Observer #2 — updates dashboard count in logs
@Component
public class DashboardObserver implements INotificationObserver {

    private int notificationCount = 0;

    @Override
    public void onNotificationSent(String title, String message, String sentTo) {
        notificationCount++;
        System.out.println("[DASHBOARD OBSERVER] Notification count is now: " + notificationCount);
    }

    public int getNotificationCount() {
        return notificationCount;
    }
}