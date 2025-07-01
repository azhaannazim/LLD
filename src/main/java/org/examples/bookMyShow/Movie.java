package org.examples.bookMyShow;

public class Movie {
    private String id;
    private String title;
    private int durationInMinutes;
    private String description;

    public Movie(String id, String title, int durationInMinutes, String description) {
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.description = description;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
