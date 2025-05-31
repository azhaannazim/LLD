package org.examples.hotel.payment;

//strategy pattern
public interface Payment {
    boolean processPayment(double amount);
}
