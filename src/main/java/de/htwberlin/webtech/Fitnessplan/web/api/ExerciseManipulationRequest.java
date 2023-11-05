package de.htwberlin.webtech.Fitnessplan.web.api;

import java.util.Date;

public class ExerciseManipulationRequest {
    private String Name;
    private int Reps;
    private int Sets;
    private int date;
    private int duration;

    public ExerciseManipulationRequest(String name, int reps, int sets, int date, int duration) {
        Name = name;
        Reps = reps;
        Sets = sets;
        this.date = date;
        this.duration = duration;


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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

