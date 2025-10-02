package com.example.designpatterns.behavioral.observer;

public class LoggingObserver implements Observer {
    @Override
    public void onUpdate(int newValue) {
        System.out.println("[LoggingObserver] New sensor value: " + newValue);
    }
}
