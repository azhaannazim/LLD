package org.examples.DesignPatterns.observer.subject;

import org.examples.DesignPatterns.observer.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements SubjectInterface {
    private int steps;
    private int activeMinutes;
    private int calories;

    private List<Observer> list = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : list){
            observer.update(this);
        }
    }

    public void newData(int steps, int activeMinutes, int calories) {
        this.steps = steps;
        this.activeMinutes = activeMinutes;
        this.calories = calories;

        System.out.println("\nFitnessData: New data received – Steps: " + steps +
                ", Active Minutes: " + activeMinutes + ", Calories: " + calories);

        notifyObservers();
    }
    public void dailyReset() {
        this.steps = 0;
        this.activeMinutes = 0;
        this.calories = 0;

        System.out.println("\nFitnessData: Daily reset performed.");
        notifyObservers();
    }

    // Getters
    public int getSteps() { return steps; }
    public int getActiveMinutes() { return activeMinutes; }
    public int getCalories() { return calories; }
}
