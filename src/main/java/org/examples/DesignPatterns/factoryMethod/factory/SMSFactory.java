package org.examples.DesignPatterns.factoryMethod.factory;

import org.examples.DesignPatterns.factoryMethod.medium.Notification;
import org.examples.DesignPatterns.factoryMethod.medium.SMS;

public class SMSFactory extends Factory {

    @Override
    public Notification createNotification() {
        return new SMS();
    }
}
