package org.examples.SOLID.OCP_DIP;

public class Processor {
    public void process(Payment paymentMethod, int amount) {
        paymentMethod.processPayment(amount);
    }
}
