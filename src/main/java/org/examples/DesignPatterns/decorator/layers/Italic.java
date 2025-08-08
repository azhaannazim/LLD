package org.examples.DesignPatterns.decorator.layers;

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
