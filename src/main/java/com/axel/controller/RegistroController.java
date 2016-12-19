package com.axel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.axel.entities.Persona;
import com.axel.entities.Usuario;
import com.axel.service.UsuarioService;
import com.axel.service.validarLogin;

@Controller
@SessionAttributes("usuario")
public class RegistroController {

	@Autowired
	private UsuarioService usService;
	
	@RequestMapping(value="/registro")
    public String registro() {
						
        return "registro";
    }
	
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
    public String registrar(@RequestParam("nombre") String nombre, @RequestParam("password") String password) {
		
		if(validarLogin.isAvailable(nombre)){
			Usuario usuario = new Usuario();
			
			usuario.setNombreUsuario(nombre);
			usuario.setPassword(password);

			usService.guardar(usuario);
				
        	return "login";
		}else return "registro";
    }
	
	@RequestMapping("/datos")//mapeo con datos para comprobar si esta la sesion iniciada con el sessionAtributte
	public String datos(ModelMap model){
		Usuario usuario = (Usuario) model.get("usuario");
		System.out.println(usuario.getNombreUsuario());
		if(validarLogin.isLogin(usuario)){
			model.put("usuario", usuario);
			return "datosPersona";
		}
		else return "home";
	}
	
	@RequestMapping(value="/registrarPersona", method = RequestMethod.POST)
    public String registrarDatos(ModelMap model, @RequestParam("nombre") String nombrePersona,
    		@RequestParam("apellido") String apellido, @RequestParam("fecha")String fecha,
    		@RequestParam("trabajo") String trabajo) {
		
		Usuario usuario = (Usuario) model.get("usuario");		
		Usuario usuario2 = usService.findByName(usuario.getNombreUsuario());
		
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		Persona persona = new Persona();		
		persona.setNombre(nombrePersona);
		persona.setApellido(apellido);
		persona.setFechaNacimiento(date);
		persona.setTrabajo(trabajo);
		persona.setUsuario(usuario2);
		
		usService.guardarPersona(persona,usuario2);
		//AL GUARDAR EN LA BBDD A LA PERSONA ESTE METODO ASOCIA A LA PERSONA CON EL USUARIO.
		//ver en la clase UsuarioService
		
		return "welcome";		
    }
	
}
