package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Proyecto;

@Controller
public class ProyectoController {
	
	   @GetMapping("/registrarProyecto") // Path para el link
	   public String registration() {
	      return "RegistrarProyecto"; // Nombre Pagina JSP
	   }
	   
	   
	   @ModelAttribute("proyecto")
	   public Proyecto setUpUserForm() {
	      return new Proyecto();
	   } 
	   
	   
	   
	   
	   


}
