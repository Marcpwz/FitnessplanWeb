package de.htwberlin.webtech.Fitnessplan.web.api;

import java.time.LocalDate;

public class TraindayManipulationRequest {

    private String Name;
    private LocalDate Date;

    public TraindayManipulationRequest(String name, LocalDate date) {
        Name = name;
        this.Date = date;
    }

    public TraindayManipulationRequest() {
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
