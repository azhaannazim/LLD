package org.examples.DesignPatterns.abstractFactory.feature;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("window checkbox paint");
    }

    @Override
    public void onSelect() {
        System.out.println("window check box select");
    }
}
