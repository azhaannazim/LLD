package org.examples.bookMyShow.payment;

//strategy pattern
public interface Payment {
    boolean processPayment(double amount);
}
