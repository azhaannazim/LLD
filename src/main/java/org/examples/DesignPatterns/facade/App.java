package org.examples.DesignPatterns.facade;

public class App {
    public static void main(String[] args) {
        HomeFacade controls = new HomeFacade();

        controls.setMorningControls();
        controls.setEveningControl();
    }
}
