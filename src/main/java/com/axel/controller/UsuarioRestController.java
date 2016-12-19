package com.axel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.axel.entities.Usuario;
import com.axel.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Usuario datosUsuario(@PathVariable("id") Long id){
		Usuario usuario = usService.buscarId(id);
		System.out.println(usuario);
		return usuario;//Spring lo parsea directamente a formato Json
	}
	
}
