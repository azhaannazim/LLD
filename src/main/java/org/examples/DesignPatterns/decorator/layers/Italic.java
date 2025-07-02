package org.examples.DesignPatterns.decorator.layers;

import org.examples.DesignPatterns.decorator.TextView;

public class Italic extends TextDecorator {
    public Italic(TextView inner) {
        super(inner);
    }
    @Override
    public void render(){
        System.out.print("<i>");
        inner.render();
        System.out.print("</i>");
    }
}
