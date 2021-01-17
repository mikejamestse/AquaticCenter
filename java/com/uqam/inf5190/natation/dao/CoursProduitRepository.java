package com.uqam.inf5190.natation.dao;

import com.uqam.inf5190.natation.entities.CoursProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursProduitRepository extends JpaRepository<CoursProduit, Long> {

    @Query(value="select * From coursproduit where saison like :x", nativeQuery = true )
    List<CoursProduit> findProduitBySaison(@Param("x")String saison);

    @Query(value="select * from coursproduit where annee = :y and saison like :x ", nativeQuery = true )
    List<CoursProduit> findProduitBySaisonAndYear(@Param("x")String saison, @Param("y")int year);

}
