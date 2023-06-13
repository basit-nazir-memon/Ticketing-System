package com.example.sdaproject;

import java.sql.Date;
import java.time.LocalDateTime;

public class Message {
    private int id;
    private String message;
    private Date dateTime;
    private User user;

    // Constructor
    public Message(String message, Date dateTime, User userId, int id) {
        this.message = message;
        this.dateTime = dateTime;
        this.user = userId;
        this.id = id;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User userId) {
        this.user = userId;
    }
}
