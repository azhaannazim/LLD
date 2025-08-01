package org.examples;

import java.time.Instant;

public class Main {
    public static void log(String message) {
        long timestamp = Instant.now().toEpochMilli();
        System.out.println(Instant.now() + "[" + timestamp + "] " + message);
    }

    public static void main(String[] args) {
        log("Application started");
    }
}
