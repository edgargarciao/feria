package co.ufps.edu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Evaluador;

public class EvaluadorController {
	
	
	
	 @GetMapping("/") // Path para el link
	   public String registration() {
	      return "";
	   }	 
	 
	 /*
	   
	   @ModelAttribute("")
	   public Estudiante setUpUserForm() {
	      return new ();
	   }
	   
	   */
	

	
	   @PostMapping("/evaluadorProyecto")
	   public String evaluarProyecto(int idProyecto, int idEvaluador) {

	      // Implement business logic to save user details into a database
	      //.....
	      
		  //model.asMap()
	      /*System.out.println("FirstName : " + estudiante.getCodigo());
	      System.out.println("FirstName : " + estudiante.getNombre());
	      System.out.println("FirstName : " + estudiante.getApellido());
	      System.out.println("FirstName : " + estudiante.getEmail());*/
	      
	      
	      //model.addAttribute("message", "User saved successfully.");

	      return "EvaluarProyectos";
	   }
	   
}
