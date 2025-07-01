package org.examples.bookMyShow.payment;

public class UPI implements Payment {
    public boolean processPayment(double amount) {
        // Process cash payment
        return true;
    }
}
