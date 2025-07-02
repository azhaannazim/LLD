package org.examples.DesignPatterns.strategy.method;

public class CreditCard implements Payment{
    @Override
    public void pay(int cost) {
        System.out.println("payment using CC : " + cost);
    }
}
