package org.examples.DesignPatterns.builder;

public class Car {
    private String engine;
    private int wheels;
    private boolean sunroof;

    private Car(Builder builder){
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                ", sunroof=" + sunroof +
                '}';
    }

    public static class Builder{
        private String engine;
        private int wheels;
        private boolean sunroof;

        public Builder setEngine(String engine){
            this.engine = engine;
            return this;
        }
        public Builder setWheels(int wheels){
            this.wheels = wheels;
            return this;
        }
        public Builder setSunRoof(boolean sunroof){
            this.sunroof = sunroof;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }
}
