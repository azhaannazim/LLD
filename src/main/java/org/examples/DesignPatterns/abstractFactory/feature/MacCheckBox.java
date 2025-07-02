package org.examples.DesignPatterns.abstractFactory.feature;

public class MacCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Mac checkbox paint");
    }

    @Override
    public void onSelect() {
        System.out.println("Mac check box select");
    }
}
