package org.examples.DesignPatterns.decorator.layers;

public class Bold extends TextDecorator {
    public Bold(TextView inner) {
        super(inner);
    }
    @Override
    public void render(){
        System.out.print("<b>");
        inner.render();
        System.out.print("</b>");
        System.out.println();
    }
}
