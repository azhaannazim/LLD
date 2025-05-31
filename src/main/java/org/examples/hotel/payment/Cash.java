package org.examples.hotel.payment;

public class Cash implements Payment{
    public boolean processPayment(double amount) {
        // Process cash payment
        return true;
    }
}
