package org.examples.DesignPatterns.observer.observers;

import org.examples.DesignPatterns.observer.subject.Subject;

public class GoalNotifier implements Observer{
    private final static int stepGoal = 10000;
    private boolean goalReached = false;

    @Override
    public void update(Subject data) {
        if (data.getSteps() >= stepGoal && !goalReached) {
            System.out.println("Notifier → 🎉 Goal Reached! You've hit " + stepGoal + " steps!");
            goalReached = true;
        }
    }

    public void reset() {
        goalReached = false;
    }
}
