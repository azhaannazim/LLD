package org.examples.DesignPatterns.facade;

public class HomeFacade {
    private final Lighting lighting;
    private final Music music;
    private final ClimateControl climateControl;

    HomeFacade(){
        lighting = new Lighting();
        music = new Music();
        climateControl = new ClimateControl();
    }

    void setMorningControls(){
        lighting.on();
        music.playMusic();
        climateControl.setTemperature(20);
    }
    void setAfternoonControls(){
        music.stop();
        lighting.on();
        climateControl.setTemperature(17);
    }
    void setEveningControl(){
        lighting.dim();
        music.playMusic();
        climateControl.setTemperature(25);
    }
    void setNightControl(){
        lighting.off();
        music.stop();
        climateControl.setTemperature(23);
    }
}
