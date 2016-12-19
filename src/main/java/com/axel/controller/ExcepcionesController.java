package com.axel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExcepcionesController {

	@RequestMapping("/error404") //Cuando recibe un 404notFound el web.xml lo redirije a esta ruta
	public @ResponseBody String notFound(){
		return "<h1>La ruta a la que quieres acceder no existe</h1>";
	}
}
