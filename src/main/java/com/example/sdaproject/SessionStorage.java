package com.example.sdaproject;

import java.util.Date;
import java.time.LocalDateTime;

public class SessionStorage {
    private static SessionStorage instance;
    private User user;
    private LocalDateTime session;

    private SessionStorage() {
        user = null;
        session = null;
    }

    public static SessionStorage getInstance() {
        if (instance == null) {
            synchronized (SessionStorage.class) {
                if (instance == null) {
                    instance = new SessionStorage();
                }
            }
        }
        return instance;
    }

    public void setSession(User user) {
        LocalDateTime now = LocalDateTime.now();
        session = now;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getSessionTime() {
        return session;
    }
}
