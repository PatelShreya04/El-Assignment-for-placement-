package com.example.designpatterns.structural.decorator;

public class EncryptionDecorator extends DataSourceDecorator {
    private final int shift;
    public EncryptionDecorator(DataSource wrappee, int shift) { super(wrappee); this.shift = shift; }

    @Override
    public byte[] readData() {
        byte[] data = wrappee.readData();
        byte[] out = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            out[i] = (byte) (data[i] + shift);
        }
        return out;
    }
}
