package com.uqam.inf5190.natation.service;

import com.uqam.inf5190.natation.entities.Cours;
import com.uqam.inf5190.natation.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    String ROLE_PREFIX = "ROLE_";
    private User user;

    public UserPrincipal(User user){
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

        authList.add(new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole()));

        return authList;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    public Long getUserId() {
        return user.getId();
    }
    public String getFirstName(){
        return user.getFirstName();
    }

    public String getLastName(){
        return user.getLastName();
    }

    public String getPhoneNumber(){
        return user.getPhoneNumber();
    }
    public String getStreetNumber() {
        return user.getStreetNumber();
    }
    public String getStreetName(){
        return user.getStreetName();
    }
    public String getTownName(){
        return user.getTownName();
    }
    public String getPostalCode(){
        return user.getPostalCode();
    }

    public List<Cours> getListCours(){
        return user.getCoursList();
    }


    // pour les 4 derniere fonctions de securite, on met les retours a true pour le 1er livrable

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

}
