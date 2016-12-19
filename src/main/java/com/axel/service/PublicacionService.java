package com.axel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axel.dao.PublicacionDao;
import com.axel.dao.UsuarioDao;
import com.axel.entities.Publicacion;
import com.axel.entities.Usuario;

@Service
public class PublicacionService {

	@Autowired
	private UsuarioDao uDao;
	
	@Autowired
	private PublicacionDao pDao;
	
	@Transactional
	public void guardar(Publicacion publicacion) {		
		pDao.save(publicacion);
	}

	//El error lazy se debe a que el metodo inicia la transaccion y al cerrarla se pierde la lista
	@Transactional(readOnly = true) 
	public List<Publicacion> findPublicaciones(Long id){
		
		List<Publicacion> publicaciones = (List<Publicacion>) pDao.findByUsuario(id);
		
		return publicaciones;
	}
	
	@Transactional(readOnly = true) 
	public List<Publicacion> userGetPublicaciones(Long id){
		
		Usuario usuario = uDao.findOne(id);
		
		List<Publicacion> publicaciones = usuario.getPublicaciones();
		
		publicaciones.size();//para que se guarde en memoria la lista y no se pierda al terminar la transacc.
		//si no lo utilizo se genera un error de tipo lazy init
		
		return publicaciones;
	}
			
	public UsuarioDao getuDao() {
		return uDao;
	}

	public void setuDao(UsuarioDao uDao) {
		this.uDao = uDao;
	}

	public PublicacionDao getpDao() {
		return pDao;
	}

	public void setpDao(PublicacionDao pDao) {
		this.pDao = pDao;
	}
	
}
