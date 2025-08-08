package org.examples.DesignPatterns.strategy;

import org.examples.DesignPatterns.strategy.method.Payment;

public class PaymentService {
    private Payment payment;

    PaymentService(Payment payment){
        this.payment = payment;
    }
    public void updateStrategy(Payment payment){
        this.payment = payment;
    }

    public void pay(int amount) {
        payment.pay(amount);
    }
}
