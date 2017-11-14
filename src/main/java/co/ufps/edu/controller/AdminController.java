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

	

	   // Devuelve el jsp
	
	   @GetMapping("/registrarEvaluador") // Path para el link
	   public String registration() {
	      return "RegistrarEvaluador";
	   }
	   
	   
	   /*
	   
	   @ModelAttribute("administrador")
	   public Estudiante setUpUserForm() {
	      return new Administrador();
	   } 
	   
	   */
	   
	
	   @PostMapping("/guardarEvaluador")
	   public String registrarEvaluador(@ModelAttribute("evaluador") Evaluador evaluador, Model model) {

	      // Implement business logic to save user details into a database
	      
	      
	     System.out.println("FirstName : " + evaluador.getCodigo());
	      System.out.println("FirstName : " + evaluador.getNombre());
	      System.out.println("FirstName : " + evaluador.getApellido());
	      System.out.println("FirstName : " + evaluador.getLinea());
	      
	      
	      model.addAttribute("message", "User saved successfully.");

	      return "RegistrarEvaluador";
	   }
	   

	   @PostMapping("/guardarEvaluador")
	   public String AsignarProyectos(@ModelAttribute("evaluador") Evaluador evaluador, Model model) {

	      // Implement business logic to save user details into a database
	      //.....
	     
	      
	      model.addAttribute("message", "User saved successfully.");

	      return "AsignarProyecto";
	   }
	   
	   
	   @PostMapping("/evaluadorProyecto")
	   public String calificarProyecto(int idProyecto, int idEvaluador) {

	      // Implement business logic to save user details into a database
	      //.....
	      
		  //model.asMap()
	      
	      
	      //model.addAttribute("message", "User saved successfully.");

	      return "CalificarProyecto";
	   }
	   
	   
	   
	   @PostMapping("/evaluadorProyecto")
	   public String registrarLineas(@ModelAttribute("evaluador") Linea linea, Model model) {

	      // Implement business logic to save user details into a database
	      //.....
	      
		  //model.asMap()
	  
	      
	      
	      //model.addAttribute("message", "User saved successfully.");

	      return "RegistrarLineas";
	   }
	   
	   
	   @PostMapping("/evaluadorProyecto")
	   public String AsignarHorario(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {

	      // Implement business logic to save user details into a database
	      //.....
	      
		  //model.asMap()
	     
	      
	      //model.addAttribute("message", "User saved successfully.");

	      return "AsignarHorario";
	   }
	   
	   
	   
}
