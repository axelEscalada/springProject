package com.axel.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.axel.entities.Publicacion;
import com.axel.entities.Usuario;
import com.axel.service.PublicacionService;

@Controller
@SessionAttributes("usuario")
public class PublicarController {

	@Autowired
	private PublicacionService pService;
	
	@RequestMapping("/publicar")
	public String publicar(ModelMap model, @RequestParam("publicacion") String contenido){
		Usuario usuario = (Usuario)model.get("usuario");
		System.out.println(usuario); //
		Publicacion publicacion = new Publicacion();
		publicacion.setContenido(contenido);
		publicacion.setUsuario(usuario);
		publicacion.setFecha(new Date());
		
		pService.guardar(publicacion);
				
		return "redirect:principal";
	}
	
}
