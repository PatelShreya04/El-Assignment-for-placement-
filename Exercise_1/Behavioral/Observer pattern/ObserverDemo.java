package com.example.designpatterns.behavioral.observer;

import java.io.BufferedReader;

public class ObserverDemo {
    public static void runDemo(BufferedReader reader) throws Exception {
        System.out.println("Observer Pattern Demo (enter numbers, 'stop' to end):");
        SensorDataPublisher publisher = new SensorDataPublisher();
        publisher.register(new LoggingObserver());
        publisher.register(new AlertObserver(50)); // threshold 50

        String line;
        while (true) {
            System.out.print("Enter sensor value (or 'back' to menu): ");
            line = reader.readLine();
            if (line == null || line.trim().equalsIgnoreCase("back")) break;
            try {
                int val = Integer.parseInt(line.trim());
                publisher.notifyObservers(val);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
