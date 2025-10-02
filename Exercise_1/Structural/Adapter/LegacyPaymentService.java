package com.example.designpatterns.structural.adapter;

import java.util.Random;

public class LegacyPaymentService {
    private final Random rnd = new Random();

    // This method simulates network/transient errors randomly
    public String doPayment(String payload) throws RuntimeException {
        if (rnd.nextInt(4) == 0) { // ~25% transient failure
            throw new RuntimeException("Transient network error");
        }
        return "OK:" + payload;
    }
}
