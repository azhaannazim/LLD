package org.examples.SOLID.SRP;

//used for generating reports
public class Reporter {
    public void generateReport(User user) {
        System.out.println("Report for " + user.getName() + ": Email is " + user.getEmail());
    }
}
