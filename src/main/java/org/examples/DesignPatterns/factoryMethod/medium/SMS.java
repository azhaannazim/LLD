package org.examples.DesignPatterns.factoryMethod.medium;

public class SMS implements Notification {
    @Override
    public void send(String message) {
        System.out.println("send SMS :" + message);
    }
}
