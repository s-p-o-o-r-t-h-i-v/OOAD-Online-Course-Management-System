package ooad.admin;

import org.springframework.stereotype.Component;

// Concrete Observer #1 — simulates sending email
@Component
public class EmailNotificationObserver implements INotificationObserver {

    @Override
    public void onNotificationSent(String title, String message, String sentTo) {
        // In a real app, integrate JavaMailSender here
        System.out.println("[EMAIL OBSERVER] Sending email to " + sentTo
                + " | Subject: " + title + " | Body: " + message);
    }
}