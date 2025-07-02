package org.examples.DesignPatterns.abstractFactory.factory;

import org.examples.DesignPatterns.abstractFactory.feature.MacButton;
import org.examples.DesignPatterns.abstractFactory.feature.MacCheckBox;
import org.examples.DesignPatterns.abstractFactory.feature.Button;
import org.examples.DesignPatterns.abstractFactory.feature.CheckBox;

public class MacFactory implements Factory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
