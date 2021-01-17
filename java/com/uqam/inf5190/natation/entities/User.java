package com.uqam.inf5190.natation.entities;

import com.uqam.inf5190.natation.entities.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name="firstName", length=20)
    private String firstName;
    @Basic
    @Column(name="lastName", length=20)
    private String lastName;
    @Basic
    @Column(name="username", length=50)
    private String username;
    @Basic
    @Column(name="password", length=30)
    private String password;
    @Basic
    @Column(name="phoneNumber", length=15)
    private String phoneNumber;
    @Basic
    @Column(name="streetNumber", length=6)
    private String streetNumber;
    @Basic
    @Column(name="streetName", length=15)
    private String streetName;
    @Basic
    @Column(name="townName", length=15)
    private String townName;
    @Basic
    @Column(name="postalCode", length=6)
    private String postalCode;

    @Column(name="role", nullable=false)
    @Enumerated(EnumType.STRING)
    private Role role;

    // Strategie de jointure, engendrer enfants
    @OneToMany(fetch = FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
    private List<Cours> cours = new ArrayList<Cours>();

    // Jpa constructor
    public User() {
    }

    public User(String firstName, String lastName, String username, String phoneNumber, String password, String streetNumber, String streetName, String townName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber =phoneNumber;
        this.password = password;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.townName = townName;
        this.postalCode = postalCode;
        setRole(Role.USER);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Cours> getCoursList() {
        return cours;
    }

    public void setCoursList(List<Cours> coursList) {
        this.cours = coursList;
    }
}
