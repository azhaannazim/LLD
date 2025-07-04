package org.examples.DesignPatterns.abstractFactory.feature;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("window button paint");
    }

    @Override
    public void click() {
        System.out.println("window button click");
    }
}
