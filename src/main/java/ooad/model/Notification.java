package ooad.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private String sentTo; // "ALL", "STUDENTS", "INSTRUCTORS"
    private LocalDateTime sentAt;

    public Notification() {
        this.sentAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String m) {
        this.message = m;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String s) {
        this.sentTo = s;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime d) {
        this.sentAt = d;
    }
}