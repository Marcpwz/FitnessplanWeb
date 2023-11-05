package de.htwberlin.webtech.Fitnessplan.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import jakarta.persistence.GenerationType;
import java.util.Date;

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
    @Column(name = "Sets", nullable = false)
    private int sets;
    @Column(name = "date")
    private int date;
    @Column(name = "duration")
    private int duration;

    public ExerciseEntity(String name, int reps, int sets, int date, int duration) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.date = date;
        this.duration = duration;
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