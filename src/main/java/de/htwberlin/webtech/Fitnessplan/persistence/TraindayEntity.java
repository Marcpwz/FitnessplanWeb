package de.htwberlin.webtech.Fitnessplan.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Trainday")
public class TraindayEntity {

    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Date")
    private LocalDate Date;

    public TraindayEntity(String name, LocalDate date) {
        this.name = name;
        Date = date;
    }

    public TraindayEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
}
