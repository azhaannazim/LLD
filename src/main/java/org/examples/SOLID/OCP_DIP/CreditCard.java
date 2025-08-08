package org.examples.SOLID.OCP_DIP;

public class CreditCard implements Payment{
    @Override
    public void processPayment(int amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
