package com.example.designpatterns.creational.factory;

public class NotificationFactory {
    public Notification create(String type) {
        if ("sms".equalsIgnoreCase(type)) return new SmsNotification();
        if ("email".equalsIgnoreCase(type)) return new EmailNotification();
        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}
