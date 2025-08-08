package org.examples.SOLID.OCP_DIP;

public class UPI implements Payment{
    @Override
    public void processPayment(int amount) {
        System.out.println("Processing UPI payment of $" + amount);
    }
}
