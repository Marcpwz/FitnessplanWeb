package de.htwberlin.webtech.Fitnessplan.web.api;

import java.util.Date;
import java.time.LocalDate;
public class Exercise {

    private long id;
    private String Name;
    private int Reps;
    private int Sets;
    private LocalDate date;
    private int duration;

    public Exercise(long id, String name, int reps, int sets, LocalDate date, int duration) {
        this.id = id;
        Name = name;
        Reps = reps;
        Sets = sets;
        this.date = date;
        this.duration = duration;
    }

    public Exercise() {
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

    public int getReps() {
        return Reps;
    }

    public void setReps(int reps) {
        Reps = reps;
    }

    public int getSets() {
        return Sets;
    }

    public void setSets(int sets) {
        Sets = sets;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}