package org.examples.DesignPatterns.facade;

public class ClimateControl {
    void setTemperature(int temperature){
        System.out.println("set temperature : " + temperature);
    }
}
class Music{
    void playMusic(){
        System.out.println("playing music");
    }
    void stop(){
        System.out.println("stop music");
    }
}
class Lighting{
    void on(){
        System.out.println("lights on");
    }
    void off(){
        System.out.println("lights off");
    }
    void dim(){
        System.out.println("lights dim");
    }
}