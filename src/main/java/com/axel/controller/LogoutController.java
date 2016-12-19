package com.axel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class LogoutController {

	@RequestMapping("/logout")
	public String logout(ModelMap model, SessionStatus status){
		//model.remove("noOmbre"); //esta forma no sirve
						
		status.setComplete();//remuevo el usuario de la session
		
		model.remove("usuario");//remuevo el usuario de usuario del modelo
		
		return "redirect:home";
	}
	
}
