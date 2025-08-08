package org.examples.SOLID.SRP;

//manage DB interactions
public class Repository {
    public void save(User user) {
        System.out.println("Saving " + user.getName() + " to the database...");
    }
}
