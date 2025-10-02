package com.example.designpatterns.structural.decorator;

public class BasicDataSource implements DataSource {
    private final String payload;
    public BasicDataSource(String payload) { this.payload = payload; }
    @Override public byte[] readData() { return payload.getBytes(); }
}
