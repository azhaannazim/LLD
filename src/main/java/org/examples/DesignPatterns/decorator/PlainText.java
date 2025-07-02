package org.examples.DesignPatterns.decorator;

public class PlainText implements TextView {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.print(text);
    }
}
