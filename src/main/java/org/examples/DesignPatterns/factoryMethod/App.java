package org.examples.DesignPatterns.factoryMethod;

import org.examples.DesignPatterns.factoryMethod.factory.EmailFactory;
import org.examples.DesignPatterns.factoryMethod.factory.Factory;
import org.examples.DesignPatterns.factoryMethod.factory.SMSFactory;

public class App {
    public static void main(String[] args) {
        Factory emailSender = new EmailFactory();
        emailSender.send("hi");
        emailSender.send("hi 2");

        Factory smsSender = new SMSFactory();
        smsSender.send("hi");
    }
}
