package org.examples.DesignPatterns.strategy;

import org.examples.DesignPatterns.strategy.method.CreditCard;
import org.examples.DesignPatterns.strategy.method.UPI;

public class App {
    public static void main(String[] args) {
        PaymentService service = new PaymentService(new CreditCard());
        service.pay(100);

        service.updateStrategy(new UPI());
        service.pay(69);
    }
}
