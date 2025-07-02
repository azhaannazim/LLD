package org.examples.DesignPatterns.observer.observers;

import org.examples.DesignPatterns.observer.subject.Subject;

public class LiveActivityDisplay implements Observer{
    @Override
    public void update(Subject data) {
        System.out.println("Live Display → Steps: " + data.getSteps() +
                " | Active Minutes: " + data.getActiveMinutes() +
                " | Calories: " + data.getCalories());
    }
}
