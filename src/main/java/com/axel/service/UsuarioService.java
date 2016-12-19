package com.axel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axel.dao.PersonaDao;
import com.axel.dao.PublicacionDao;
import com.axel.dao.UsuarioDao;
import com.axel.entities.Persona;
import com.axel.entities.Publicacion;
import com.axel.entities.Usuario;

@Service
public class UsuarioService {

	private UsuarioDao uDao;
	private PersonaDao personaDao;
	private PublicacionDao publicacionDao;

	@Transactional
	public void guardar(Usuario usuario) {
		uDao.save(usuario);
	}
	
	@Transactional
	public Usuario findByName(String nombre) {
		return uDao.findByName(nombre);
	}
	
	@Transactional(readOnly = true)
	public Usuario buscarId(Long id){
		return uDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Usuario> listaUsuarios() {
		List<Usuario> usuarios = uDao.findAll();

		return usuarios;
	}

	@Transactional
	public void borrar(Long id) {
		uDao.delete(id);
	}

	@Transactional(readOnly = true)
	public Usuario obtenerPorId(Long id) {
		return uDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public String nombre(String nombre){
		return uDao.getNombre(nombre);
	}

	@Transactional
	public void actualizar(Long id, String nombreUsuario, String password){
		Usuario usuario = uDao.findOne(id);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setPassword(password);
		uDao.save(usuario);
	}
	
	@Transactional
	public void guardarPersona(Persona persona, Usuario usuario) {
		personaDao.save(persona);
		usuario.setPersona(persona);
		uDao.save(usuario);
	}

	public UsuarioDao getuDao() {
		return uDao;
	}

	@Autowired
	public void setuDao(UsuarioDao uDao) {
		this.uDao = uDao;
	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	@Autowired
	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

	public PublicacionDao getPublicacionDao() {
		return publicacionDao;
	}

	@Autowired
	public void setPublicacionDao(PublicacionDao publicacionDao) {
		this.publicacionDao = publicacionDao;
	}

	
	
}
