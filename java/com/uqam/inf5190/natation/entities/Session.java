package com.uqam.inf5190.natation.entities;


import com.uqam.inf5190.natation.entities.enums.Saison;

import javax.persistence.*;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue
    private Long sessionId;
    @Enumerated(EnumType.STRING)
    private Saison saison;
    @Basic
    @Column
    private int year;

    public Session(Saison saison, int year) {
        this.saison = saison;
        this.year = year;
    }

    // JPA
    public Session(){

    }

    public Long getSessionId() {
        return sessionId;
    }


    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
