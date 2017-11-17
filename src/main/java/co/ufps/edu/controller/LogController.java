package co.ufps.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.LoginDao;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Login;

@Controller
public class LogController {
	

	  
	  @Autowired
	  private RedisTemplate<String,String> template;
	  
	  private LoginDao loginDao = new LoginDao();

	   @GetMapping("/accesoEstudiante") // Base
	   public String index() {
	      return "Login"; // Nombre del archivo jsp
	   }
	   
		@ModelAttribute("login")
		public Login setUpUserForm() {
			return new Login();
		}

	  	  
	   
	   @PostMapping("/autenticar")
	   public String authenticateUser(//@RequestParam("codigo") int codigo, @RequestParam("contraseña") String contraseña ,Model model) {
			   @ModelAttribute("login") Login login,Model model){
		  // String resultado = loginDao.authenticate(codigo, contraseña);
		   System.out.println("coming in controller    " +login.getCodigo()+" : "+ login.getContraseña());  
	       template.opsForValue().set("SESSSION:"+login.getCodigo(), "dsadsdsadasdasdas");
		   
		   
		   //model.addAttribute("message", "Hello Spring MVC Framework!");
	       return "indexAdmin";
	    }
	  
}
