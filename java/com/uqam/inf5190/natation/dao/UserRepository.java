package com.uqam.inf5190.natation.dao;

import com.uqam.inf5190.natation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    // fonction de recherche par username
    @Query(value="SELECT * FROM users WHERE username LIKE :x", nativeQuery = true)
    User findUserByUsername(@Param("x") String email);
}