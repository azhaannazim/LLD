package org.examples.DesignPatterns.factoryMethod.factory;

import org.examples.DesignPatterns.factoryMethod.medium.Email;
import org.examples.DesignPatterns.factoryMethod.medium.Notification;

public class EmailFactory extends Factory {

    @Override
    public Notification createNotification() {
        return new Email();
    }
}
