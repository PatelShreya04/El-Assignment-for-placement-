package com.example.designpatterns.structural.adapter;

public interface PaymentProcessor {
    boolean process(PaymentRequest req) throws Exception;
}
