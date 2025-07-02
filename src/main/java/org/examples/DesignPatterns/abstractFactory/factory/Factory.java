package org.examples.DesignPatterns.abstractFactory.factory;

import org.examples.DesignPatterns.abstractFactory.feature.Button;
import org.examples.DesignPatterns.abstractFactory.feature.CheckBox;

public interface Factory {
    Button createButton();
    CheckBox createCheckBox();
}
