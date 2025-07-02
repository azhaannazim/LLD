package org.examples.DesignPatterns.decorator;

import org.examples.DesignPatterns.decorator.layers.Bold;
import org.examples.DesignPatterns.decorator.layers.Italic;
import org.examples.DesignPatterns.decorator.layers.TextDecorator;

public class App {
    public static void main(String[] args) {
        TextView plainText = new PlainText("hi");
        plainText.render();

        TextDecorator bold = new Bold(plainText);
        bold.render();

        TextDecorator italic = new Italic(bold);
        italic.render();
    }
}
