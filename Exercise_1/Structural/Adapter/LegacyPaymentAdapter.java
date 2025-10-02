package com.example.designpatterns.structural.adapter;

import com.example.designpatterns.utils.RetryExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class LegacyPaymentAdapter implements PaymentProcessor {
    private static final Logger logger = LoggerFactory.getLogger(LegacyPaymentAdapter.class);
    private final LegacyPaymentService service;
    private final RetryExecutor retry;

    public LegacyPaymentAdapter(LegacyPaymentService service, RetryExecutor retry) {
        this.service = service;
        this.retry = retry;
    }

    @Override
    public boolean process(PaymentRequest req) throws Exception {
        Callable<Boolean> work = () -> {
            String payload = req.account + ":" + req.amount;
            String res = service.doPayment(payload);
            logger.info("Legacy service response: {}", res);
            return res != null && res.startsWith("OK");
        };
        return retry.executeWithRetry(work);
    }
}
