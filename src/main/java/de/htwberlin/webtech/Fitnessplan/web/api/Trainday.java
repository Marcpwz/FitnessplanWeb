package de.htwberlin.webtech.Fitnessplan.web.api;

import java.time.LocalDate;

public class Trainday {

    private long id;
    private String Name;
    private LocalDate Date;

    public Trainday(long id, String name, LocalDate date) {
        this.id = id;
        Name = name;
        this.Date = date;
    }

    public Trainday() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        this.Date = date;
    }
}
