package com.axel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axel.entities.Publicacion;

@Repository
public interface PublicacionDao extends JpaRepository<Publicacion,Long>{

	@Query("SELECT p FROM Publicacion p WHERE (p.usuario) = (?1)")
	public Publicacion findByUsuario(Long id);
	
}
