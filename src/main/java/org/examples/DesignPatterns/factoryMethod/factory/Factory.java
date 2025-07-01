package org.examples.DesignPatterns.factoryMethod.factory;

import org.examples.DesignPatterns.factoryMethod.medium.Notification;

public abstract class Factory {
    public abstract Notification createNotification();

    public void send(String message){
        Notification notification = createNotification();
        notification.send(message);
    }
}
