package com.axel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axel.entities.Imagen;
import com.axel.entities.Usuario;

public interface ImagenDao extends JpaRepository<Imagen,Long>{

}
