package com.example.designpatterns.behavioral.observer;

public interface Subject {
    void register(Observer obs);
    void unregister(Observer obs);
    void notifyObservers(int newValue);
}
