package org.examples.DesignPatterns.abstractFactory;

import org.examples.DesignPatterns.abstractFactory.factory.Factory;
import org.examples.DesignPatterns.abstractFactory.feature.Button;
import org.examples.DesignPatterns.abstractFactory.feature.CheckBox;

public class UI {
    private final Button button;
    private final CheckBox checkbox;

    public UI(Factory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckBox();
    }

    public void renderUI() {
        button.paint();
        checkbox.paint();
    }
}
