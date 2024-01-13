package de.htwberlin.webtech.Fitnessplan.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import jakarta.persistence.GenerationType;

import java.time.LocalTime;

@Entity(name = "exercise")
public class ExerciseEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Reps")
    private int reps;
    @Column(name = "Sets")
    private int sets;
    @Column(name = "Weight")
    private float Weight;
    @Column(name = "duration")
    private LocalTime duration;

    @Column(name = "tid")
    private Long tid;

    public ExerciseEntity(String name, int reps, int sets, float weight, LocalTime duration, Long tid) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        Weight = weight;
        this.duration = duration;
        this.tid = tid;
    }

    protected ExerciseEntity() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
}