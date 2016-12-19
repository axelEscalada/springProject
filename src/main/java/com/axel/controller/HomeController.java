package com.axel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.axel.entities.Publicacion;
import com.axel.entities.Usuario;
import com.axel.service.PublicacionService;
import com.axel.service.validarLogin;

@Controller
@SessionAttributes("usuario")
public class HomeController {

	@Autowired
	public PublicacionService pService;
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}	
	
	/*@RequestMapping(value = "/welcome")
	public String welcome(@ModelAttribute("nombre")String nombre, ModelMap model) {
		System.out.println(nombre + " welcome");
		if(validarLogin.isLogin(nombre)) return "welcome";
		else return "redirect:home";
	}*/
	
	@RequestMapping(value = "/welcome")
	public String welcome(ModelMap model) {
		Usuario usuario = (Usuario) model.get("usuario");
		System.out.println(usuario);
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
			List<Publicacion> publicaciones = pService.userGetPublicaciones(usuario.getId());
			
			model.addAttribute("publicaciones", publicaciones);			

			//publicaciones.forEach(System.out::println);
			
			model.addAttribute("usuario", usuario);
			return "inicio";
		}
		else return "redirect:home";
	}
	
}
