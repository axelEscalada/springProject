package com.axel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axel.entities.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario,Long>{

	@Query("SELECT u FROM Usuario u WHERE LOWER(u.nombreUsuario) = LOWER(?1)")
	public Usuario findByName(String name);
	
	@Query("SELECT nombreUsuario FROM Usuario WHERE nombreUsuario = LOWER(?1)")
	public String getNombre(String nombre);
	
}
