package org.examples.DesignPatterns.abstractFactory.factory;

import org.examples.DesignPatterns.abstractFactory.feature.WindowsButton;
import org.examples.DesignPatterns.abstractFactory.feature.WindowsCheckBox;
import org.examples.DesignPatterns.abstractFactory.feature.Button;
import org.examples.DesignPatterns.abstractFactory.feature.CheckBox;

public class WindowsFactory implements Factory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
