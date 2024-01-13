package de.htwberlin.webtech.Fitnessplan.web.api;

import java.time.LocalTime;

public class Exercise {

    private long id;
    private String Name;
    private int Reps;
    private int Sets;
    private float Weight;
    private LocalTime duration;
    private Long tid;

    public Exercise(long id, String name, int reps, int sets, float weight, LocalTime duration, Long tid) {
        this.id = id;
        Name = name;
        Reps = reps;
        Sets = sets;
        Weight = weight;
        this.duration = duration;
        this.tid = tid;
    }

    public Exercise() {
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
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
}