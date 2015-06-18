package models;

import play.libs.Time;

import java.time.LocalDateTime;

public class Event {
    public String title;
    public LocalDateTime date;
    public String location;
    public String description;

    public Event(String title, LocalDateTime date, String location, String description) {
        this.title = title;
        this.date = date;
        this.location= location;
        this.description = description;
    }
}