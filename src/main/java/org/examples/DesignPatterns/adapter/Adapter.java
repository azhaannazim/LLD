package org.examples.DesignPatterns.adapter;

public class Adapter implements Target{ //implements target , uses adaptee internally
    private final Adaptee legacyPlayer;

    public Adapter(){
        legacyPlayer = new Adaptee();
    }

    @Override
    public void play(String type, String fileName) {
        if(type.equalsIgnoreCase("vlc")){
            legacyPlayer.playVlc(fileName);
        }
        else if (type.equalsIgnoreCase("mp4")) {
            legacyPlayer.playMp4(fileName);
        }
        else{
            System.out.println("unsupported format : " + type);
        }
    }
}
