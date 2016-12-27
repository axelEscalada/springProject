package com.axel.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.axel.entities.Publicacion;
import com.axel.entities.Usuario;
import com.axel.service.ImagenService;
import com.axel.service.PublicacionService;
import com.axel.service.UsuarioService;
import com.axel.service.validarLogin;

@Controller
@SessionAttributes("usuario")
public class HomeController {

	@Autowired
	private PublicacionService pService;
	
	@Autowired
	private UsuarioService usService;
	
	@Autowired
	private ImagenService imagenService; 
	
	@RequestMapping("/home")
	public String home(ModelMap model){
		Usuario usuario = (Usuario) model.get("usuario");
		if(validarLogin.isLogin(usuario)){
			model.addAttribute("usuario", usuario);
			return "welcome";
		}else return "home";
	}	
	
	@RequestMapping(value = "/welcome")
	public String welcome(ModelMap model) {
		Usuario usuario = (Usuario) model.get("usuario");
		
		if(validarLogin.isLogin(usuario)){
			model.addAttribute("usuario", usuario);
			return "welcome";
		}
		else return "redirect:home";
	}
	
	@RequestMapping("/principal")
	public String inicio(ModelMap model){
		Usuario usuario = (Usuario) model.get("usuario");
		if(validarLogin.isLogin(usuario)){
			Long id = usuario.getId();

			List<Publicacion> publicaciones = pService.userGetPublicaciones(id);
			
			byte[] foto = imagenService.getFoto(id);
			byte[] encoded=Base64.getEncoder().encode(foto);
			String encodedString = new String(encoded);
						
			model.addAttribute("publicaciones", publicaciones);
			model.addAttribute("foto", encodedString);
			
			model.addAttribute("usuario", usuario);
			return "inicio";
		}
		else return "redirect:home";
	}
	
}
