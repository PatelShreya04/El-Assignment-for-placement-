package com.example.designpatterns.structural.decorator;

public class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource wrappee) { super(wrappee); }

    @Override
    public byte[] readData() {
        byte[] original = wrappee.readData();
        // simulate compression: reverse bytes (toy example)
        byte[] out = new byte[original.length];
        for (int i = 0; i < original.length; i++) out[i] = original[original.length - 1 - i];
        return out;
    }
}
