package org.examples.DesignPatterns.abstractFactory.feature;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac button paint");
    }

    @Override
    public void click() {
        System.out.println("Mac button click");
    }
}
