package de.htwberlin.webtech.Fitnessplan.web.api;

import java.time.LocalTime;


public class ExerciseManipulationRequest {
    private String Name;
    private int Reps;
    private int Sets;
    private float Weight;
    private LocalTime duration;
    private Long tid;

    public ExerciseManipulationRequest(String name, int reps, int sets, float weight, LocalTime duration, Long tid) {
        Name = name;
        Reps = reps;
        Sets = sets;
        Weight = weight;
        this.duration = duration;
        this.tid = tid;
    }

    public  ExerciseManipulationRequest()
    {}

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

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public float getWeight() {
        return Weight;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
}

