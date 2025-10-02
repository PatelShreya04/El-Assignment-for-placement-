package com.example.designpatterns.creational.factory;

import java.io.BufferedReader;

public class FactoryDemo {
    public static void runDemo(BufferedReader reader) throws Exception {
        System.out.println("Factory Method Demo");
        System.out.print("Enter notification type (email/sms): ");
        String type = reader.readLine();
        System.out.print("Enter message: ");
        String msg = reader.readLine();

        NotificationFactory factory = new NotificationFactory();
        try {
            Notification n = factory.create(type);
            n.send(msg);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
