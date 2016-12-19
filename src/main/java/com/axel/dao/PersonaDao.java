package com.axel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.axel.entities.Persona;

@Repository
public interface PersonaDao extends JpaRepository<Persona,Long>{

}
