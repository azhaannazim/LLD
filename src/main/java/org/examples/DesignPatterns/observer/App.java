package org.examples.DesignPatterns.observer;

import org.examples.DesignPatterns.observer.observers.GoalNotifier;
import org.examples.DesignPatterns.observer.observers.LiveActivityDisplay;
import org.examples.DesignPatterns.observer.observers.Observer;
import org.examples.DesignPatterns.observer.subject.Subject;

public class App {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer LiveActivity = new LiveActivityDisplay();
        Observer goalNotifier = new GoalNotifier();

        subject.registerObserver(LiveActivity);
        subject.registerObserver(goalNotifier);

        subject.newData(500, 5, 20);
        subject.newData(10001 ,40 ,200);


    }
}
