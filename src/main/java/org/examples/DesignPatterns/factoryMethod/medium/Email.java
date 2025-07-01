package org.examples.DesignPatterns.factoryMethod.medium;

public class Email implements Notification {
    @Override
    public void send(String message) {
        System.out.println("send email :" + message);
    }
}
