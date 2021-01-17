package com.uqam.inf5190.natation.dao;

import com.uqam.inf5190.natation.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> { 

    @Query(value="Select * from Cours where niveau like :x ", nativeQuery = true)
    List<Cours> findByNiveau(@Param("x")String niveau);

    @Query(value="select * from Cours where user_id = :i", nativeQuery = true)
    List<Cours> findByUserId(@Param("i")int id);

    @Query(value="select * from Cours where user_id = :i AND status LIKE :s", nativeQuery = true)
    List<Cours> findByUserIdAndStatus(@Param("i")int id, @Param("s")String status);
}
