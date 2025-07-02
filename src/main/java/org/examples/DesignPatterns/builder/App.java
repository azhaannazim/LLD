package org.examples.DesignPatterns.builder;

public class App {
    public static void main(String[] args) {
        Car car = new Car.Builder()
                .setEngine("V8")
                .setSunRoof(true)
                .build();

        System.out.println(car);
    }
}
