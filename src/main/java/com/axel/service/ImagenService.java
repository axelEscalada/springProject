package com.axel.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.axel.dao.ImagenDao;
import com.axel.dao.UsuarioDao;
import com.axel.entities.Imagen;
import com.axel.entities.Usuario;
import com.mysql.jdbc.Blob;

@Service
public class ImagenService {
	
	@Autowired
	private ImagenDao imagenDao;
	
	@Autowired
	private UsuarioDao uDao;
	
	@Transactional
	public void guardar(Imagen imagen){
		imagenDao.save(imagen);
	}
	
	@Transactional(readOnly = true)
	public Imagen getImagen(Long id){
		Usuario usuario = uDao.findOne(id);
		
		Imagen imagen = usuario.getImagen();
		
		return imagen;
	}
	
	@Transactional
	public byte [] getFoto(Long id){
		Usuario usuario = uDao.findOne(id);
		
		Imagen imagen = null;
		byte[] foto = null;
		
		try {
			imagen = usuario.getImagen();
			foto = imagen.getFoto();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return foto;
	}
}
