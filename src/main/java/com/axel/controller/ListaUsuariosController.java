package com.axel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.axel.entities.Usuario;
import com.axel.service.UsuarioService;
import com.axel.service.validarLogin;

@Controller
@SessionAttributes("usuario") // Traigo el atributo guardado en la session
public class ListaUsuariosController {

	@Autowired
	private UsuarioService usService;

	@RequestMapping(value = "/lista")
	public String lista(ModelMap model) {
		Usuario usuario = (Usuario) model.get("usuario"); //traigo el nombre del modelo
		if (validarLogin.isLogin(usuario)) { //chequeo si es null o si esta logueado
			
			model.addAttribute("usuarios", usService.listaUsuarios()); // agrego la lista al modelo para poder recibirla en el jsp(html)
			// Recibo la lista de usuarios de la base de datos y la guardo en una variable
			
			return "listaUsuarios";
		} else return "redirect:home";
	}

	public UsuarioService getUsService() {
		return usService;
	}

	
	public void setUsService(UsuarioService usService) {
		this.usService = usService;
	}
	
	

}
