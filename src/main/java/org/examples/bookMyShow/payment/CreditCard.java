package org.examples.bookMyShow.payment;

public class CreditCard implements Payment {
    public boolean processPayment(double amount) {
        // Process cash payment
        return true;
    }
}
