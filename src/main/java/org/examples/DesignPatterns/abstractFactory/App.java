package org.examples.DesignPatterns.abstractFactory;

import org.examples.DesignPatterns.abstractFactory.factory.Factory;
import org.examples.DesignPatterns.abstractFactory.factory.MacFactory;
import org.examples.DesignPatterns.abstractFactory.factory.WindowsFactory;

public class App {
    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        Factory factory;

        if (os.contains("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        UI app = new UI(factory);
        app.renderUI();
    }
}
