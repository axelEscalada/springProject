package com.axel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axel.entities.Publicacion;
import com.axel.entities.Usuario;

public interface PublicacionDao extends JpaRepository<Publicacion,Long>{

}
