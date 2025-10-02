package com.example.designpatterns.structural.adapter;

public class PaymentRequest {
    public final String account;
    public final double amount;
    public PaymentRequest(String account, double amount) { this.account = account; this.amount = amount; }
}
