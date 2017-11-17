package co.ufps.edu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.model.Administrador;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.Linea;
import co.ufps.edu.model.Proyecto;

public class AdminController {

	
	
	
	
	
	   @ModelAttribute("administrador")
	   public Administrador setUpUserForm() {
	      return new Administrador();
	   } 
	   
	   
	   
	   @PostMapping("/asignarProyecto")
	   public String AsignarProyectos(@ModelAttribute("evaluador") Evaluador evaluador, Model model) {

	      // Implement business logic to save user details into a database
	      //.....
	     
	      
	      model.addAttribute("message", "User saved successfully.");

	      return "AsignarProyecto";
	   }
	   
	   
	   @PostMapping("/calificarProyecto")
	   public String calificarProyecto(int idProyecto, int idEvaluador) {

	      // Implement business logic to save user details into a database
	      //.....
	      
		  //model.asMap()
	      
	      
	      //model.addAttribute("message", "User saved successfully.");

	      return "CalificarProyecto";
	   }
	   
	  
	   
	   @PostMapping("/AsignarHorario")
	   public String AsignarHorario(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {

	      // Implement business logic to save user details into a database
	      //.....
	      
		  //model.asMap()
	     
	      
	      //model.addAttribute("message", "User saved successfully.");

	      return "AsignarHorario";
	   }
	   
	   
	   
}
