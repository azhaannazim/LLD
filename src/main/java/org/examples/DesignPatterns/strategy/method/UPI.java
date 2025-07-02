package org.examples.DesignPatterns.strategy.method;

public class UPI implements Payment{
    @Override
    public void pay(int cost) {
        System.out.println("payment using UPI : " + cost);
    }
}
