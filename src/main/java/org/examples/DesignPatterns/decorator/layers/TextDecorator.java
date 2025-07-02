package org.examples.DesignPatterns.decorator.layers;

import org.examples.DesignPatterns.decorator.TextView;

public abstract class TextDecorator implements TextView {
    public TextView inner;

    public TextDecorator(TextView inner) {
        this.inner = inner;
    }
}
