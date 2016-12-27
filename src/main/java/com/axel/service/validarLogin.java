package com.axel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axel.entities.Usuario;

@Service
public class validarLogin {

	private static UsuarioService usService;

	public boolean validar(String nombre, String password) {
		
		boolean resultado = false;
		
		Usuario usuario;
		String contra = null;
		
		try{
			usuario = usService.findByName(nombre);
		
			contra = usuario.getPassword();
			
			if(contra.equalsIgnoreCase(password)){
				resultado = true;
			}	
		}catch(NullPointerException e){
			e.getClass();
		}

		return resultado;
	}
	
	public static boolean isLogin(Usuario usuario){
		if(usuario != null)	return true;
		else return false;		
	}

	public static boolean isAvailable(String nombre){
				
		String name = usService.nombre(nombre);
		
		System.out.println(name);
		
		if(name != null) return false;	

		return true;
	}
	
	public UsuarioService getUsService() {
		return usService;
	}

	@Autowired
	public void setUsService(UsuarioService usService) {
		this.usService = usService;
	}	

}
