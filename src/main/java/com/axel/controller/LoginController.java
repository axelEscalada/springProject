package com.axel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.axel.entities.Usuario;
import com.axel.service.UsuarioService;
import com.axel.service.validarLogin;

@Controller
@SessionAttributes("usuario")
public class LoginController {

	@Autowired
	private UsuarioService usService;
	
	@Autowired
	private validarLogin validador;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/iniciar", method = RequestMethod.POST)
	public String validar(@RequestParam("nombre") String nombre, @RequestParam("password") String password, ModelMap model) {

		if (validador.validar(nombre, password)) {
			Usuario usuario = usService.findByName(nombre); //Recupero el usuario de la bbdd
			//System.out.println(usuario);
			model.addAttribute("usuario", usuario); //lo guardo en el modelo y la session
						
			return "redirect:welcome";
		} else{
			return "redirect:login";
		}
	}

	

}
