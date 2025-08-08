package org.examples.SOLID.SRP;

//manage user data only
public class User {
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
