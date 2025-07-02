package org.examples.DesignPatterns.observer.subject;

import org.examples.DesignPatterns.observer.observers.Observer;

public interface SubjectInterface {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
