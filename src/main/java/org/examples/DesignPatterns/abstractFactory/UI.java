package org.examples.DesignPatterns.abstractFactory;

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
