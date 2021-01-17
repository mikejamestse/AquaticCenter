package com.uqam.inf5190.natation.entities;

import com.uqam.inf5190.natation.entities.enums.Days;
import com.uqam.inf5190.natation.entities.enums.Niveau;
import com.uqam.inf5190.natation.entities.enums.Saison;

import javax.persistence.*;

@Entity
@Table(name = "coursproduit")
public class CoursProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCours;

    @Basic
    @Column(name = "price")
    private double price;

    @Basic
    @Column(name = "capacity")
    private int capacity;

    @Basic
    @Column(name = "description")
    private String description;
    
    @Basic
    @Column(name="starthour")
    private int startHour;

    @Basic
    @Column(name="endhour")
    private int endHour;

    @Basic
    @Column(name="annee")
    private int annee;

    @Enumerated(EnumType.STRING)
    private Saison saison;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    
    @Enumerated(EnumType.STRING)
    private Days daySchedule;


    public CoursProduit(double price, int capacity, String description, int startHour, int endHour, int annee, Saison saison, Niveau niveau, Days daySchedule) {
        this.price = price;
        this.capacity = capacity;
        this.description = description;
        this.startHour = startHour;
        this.endHour = endHour;
        this.annee = annee;
        this.saison = saison;
        this.niveau = niveau;
        this.daySchedule = daySchedule;
    }
    public CoursProduit(){

    }


    public Long getIdCours() {
        return idCours;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Days getDaySchedule() {
        return daySchedule;
    }

    public void setDaySchedule(Days daySchedule) {
        this.daySchedule = daySchedule;
    }
}
