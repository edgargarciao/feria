package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class LogController {

	   @GetMapping("/accesoEstudiante") // Base
	   public String index() {
	      return "Login"; // Nombre del archivo jsp
	   }
	   
	   
	   
	  /*
	   @ModelAttribute("estudiante")
	   
	   public Estudiante setUpUserForm() {
	     return new LoginEstudiante();
	   } 
	   */
	   
	   @PostMapping("/validarEstudiante")
	   public String validarEstudiante(@ModelAttribute("estudiante")  int codigo , String Contraseña, Model model) {

	      // Implement business logic to save user details into a database
	      //.....
		   
		   
	      
	      
	      
	      model.addAttribute("message", "User saved successfully.");
	      

	      return "validarEstudiante";
	   }
	
	  
}
