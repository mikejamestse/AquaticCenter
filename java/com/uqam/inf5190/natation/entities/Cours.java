package com.uqam.inf5190.natation.entities;

import com.uqam.inf5190.natation.entities.enums.Niveau;
import com.uqam.inf5190.natation.entities.enums.Status;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "capacity")
    private int capacity;
    @Basic
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    //private Long userId;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * parametrized constructor
     * @param price
     * @param capacity
     * @param description
     * @param niveau
     */
    public Cours(double price, int capacity, String description, Niveau niveau, User user, Status status) {
        this.price = price;
        this.capacity = capacity;
        this.description = description;
        this.niveau = niveau;
        this.status = status;
        this.user = user;
    }

    /**
     * void params constructor for JPA integration
     */
    public Cours() {

    }

    // Generation of getters & setters

    public Long getId() {
        return id;
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

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
