package org.examples.DesignPatterns.adapter;

public class App {
    public static void main(String[] args) {
        Target mediaPlayer = new Adapter();
        mediaPlayer.play("mp4" , "abc");
    }
}
