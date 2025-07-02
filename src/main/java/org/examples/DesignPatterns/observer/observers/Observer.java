package org.examples.DesignPatterns.observer.observers;

import org.examples.DesignPatterns.observer.subject.Subject;

public interface Observer {
    void update(Subject data);
}
