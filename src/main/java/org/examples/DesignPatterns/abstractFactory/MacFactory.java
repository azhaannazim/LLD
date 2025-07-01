package org.examples.DesignPatterns.abstractFactory;

public class MacFactory implements Factory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
