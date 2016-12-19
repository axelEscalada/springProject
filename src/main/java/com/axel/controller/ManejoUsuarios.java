package com.axel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axel.entities.Usuario;
import com.axel.service.UsuarioService;

@Controller
@RequestMapping("/managed")
public class ManejoUsuarios {

	//FALTA CREAR EL TIPO/ROLES DE USUARIO, PARA QUE PUEDA HABER ADMINISTRADORES Y USUARIOS.
	//FALTA PONER LA RESTRICCION PARA QUE SOLO PUEDAN ENTRAR LOS ADMINISTRADORES.
	
    @Autowired
    private UsuarioService usService;

    @RequestMapping("/{id}")
    public String editar(ModelMap model, @PathVariable Long id){
    	Usuario us = usService.buscarId(id);
    	System.out.println(us);
    	model.put("usuario", us);//paso el usuario a la vista para recuperar sus datos y usarlos
		model.put("id", id);
    	return "editar";
    }
    
    @RequestMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @RequestParam("nombre") String nombreUsuario,
    		@RequestParam("password") String password){
    	usService.actualizar(id, nombreUsuario, password);
    	
    	return "redirect:/lista";
    }

    @RequestMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id /*@ModelAttribute("id")Long id*/){
    	/*Usuario us = usService.buscarId(id);
    	System.out.println(us);*/
        
    	usService.borrar(id);
    	return "redirect:/lista";// de esta forma me redirecciona al controlador "/lista"
    	//return "/lista"; busca un jsp en la carpeta views con el nombe lista, lanza una excepcion al no encontrarlo
    	//return "redirect:lista"; agrega el subfijo lista al final del url "/managed/borrar/lista" y eso lanza una excep.
    }

    

}