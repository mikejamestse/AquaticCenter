package com.uqam.inf5190.natation.dao;

import com.uqam.inf5190.natation.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaisonRepository extends JpaRepository<Session, Long> {

    List<Session> findAll();

}
