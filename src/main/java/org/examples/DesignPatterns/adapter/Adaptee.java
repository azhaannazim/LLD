package org.examples.DesignPatterns.adapter;

public class Adaptee{
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
