package com.example.designpatterns.behavioral.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SensorDataPublisher implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void register(Observer obs) { observers.add(obs); }

    @Override
    public void unregister(Observer obs) { observers.remove(obs); }

    @Override
    public void notifyObservers(int newValue) {
        for (Observer o : observers) {
            try {
                o.onUpdate(newValue);
            } catch (Exception e) {
                // defensive: log and continue
                System.err.println("Observer error: " + e.getMessage());
            }
        }
    }
}
