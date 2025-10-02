package com.example.designpatterns.behavioral.observer;

public class AlertObserver implements Observer {
    private final int threshold;

    public AlertObserver(int threshold) { this.threshold = threshold; }

    @Override
    public void onUpdate(int newValue) {
        if (newValue > threshold) {
            System.out.println("[AlertObserver] ALERT! Value " + newValue + " exceeded threshold " + threshold);
        }
    }
}
