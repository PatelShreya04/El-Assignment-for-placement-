package com.example.designpatterns.structural.decorator;

import java.io.BufferedReader;
import java.util.Base64;

public class DecoratorDemo {
    public static void runDemo(BufferedReader reader) throws Exception {
        System.out.println("Decorator Pattern Demo");
        System.out.print("Enter a string payload: ");
        String payload = reader.readLine();

        DataSource ds = new BasicDataSource(payload);
        System.out.println("Raw: " + new String(ds.readData()));

        DataSource compressed = new CompressionDecorator(ds);
        DataSource encryptedThenCompressed = new EncryptionDecorator(compressed, 3);

        byte[] finalData = encryptedThenCompressed.readData();
        System.out.println("Final (base64): " + Base64.getEncoder().encodeToString(finalData));
    }
}
