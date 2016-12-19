package com.axel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axel.entities.Usuario;
import com.axel.service.UsuarioService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	private UsuarioService usService;

	@RequestMapping("/{id}")
	public String perfil(Model model, @PathVariable Long id) {

		Usuario us = usService.buscarId(id);

		model.addAttribute("usuario", us);

		return "perfil";
	}

}
