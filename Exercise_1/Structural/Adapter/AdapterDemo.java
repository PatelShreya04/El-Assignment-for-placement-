package com.example.designpatterns.structural.adapter;

import com.example.designpatterns.utils.Config;
import com.example.designpatterns.utils.RetryExecutor;

import java.io.BufferedReader;

public class AdapterDemo {
    public static void runDemo(BufferedReader reader) throws Exception {
        System.out.println("Adapter Pattern Demo (adapting a legacy payment service).");
        System.out.print("Account: ");
        String account = reader.readLine();
        System.out.print("Amount: ");
        String amtS = reader.readLine();
        double amount = Double.parseDouble(amtS);

        int max = Config.getInt("retry.maxAttempts", 3);
        int base = Config.getInt("retry.baseDelayMs", 200);
        RetryExecutor retry = new RetryExecutor(max, base);

        LegacyPaymentService legacy = new LegacyPaymentService();
        PaymentProcessor processor = new LegacyPaymentAdapter(legacy, retry);

        boolean ok = processor.process(new PaymentRequest(account, amount));
        System.out.println("Payment processed: " + ok);
    }
}
