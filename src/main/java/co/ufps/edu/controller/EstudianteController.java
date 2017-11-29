package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.ufps.edu.dao.EstudianteDao;
import co.ufps.edu.model.Estudiante;

@Controller
public class EstudianteController {

	private EstudianteDao estudianteDao = new EstudianteDao();
	
	@Autowired
	private LogController logController; 

	
	@GetMapping("/registrarEstudiante")
	public String registration(HttpServletRequest request) {
		/*request.getSession().setAttribute("sw", false);
		request.getSession().setAttribute("titleMessage", "");
		request.getSession().setAttribute("message", "");*/
		return "RegistrarEstudiante";
	}

	@ModelAttribute("estudiante")
	public Estudiante setUpUserForm() {
		return new Estudiante();
	}
	
	@GetMapping("/index") // Base
	public String main() {
		return "index"; // Nombre del archivo jsp
	}

	@PostMapping(value = "/guardarEstudiante")
	public String registrarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante, Model model) {
		if (esCodigoValido()) {
		}
		
		try{
			boolean result = estudianteDao.registrarEstudiante(estudiante);
		}catch(Exception e) {
			
		}
		
		return "redirect:/index"; 
	}

	private boolean esCodigoValido() {
		return true;
	}
	
	// Devuelve el jsp
	@GetMapping("/indexEstudiante") // Path para el link
	public String getIndex(@RequestParam("t") String token,HttpServletRequest request) {		
		logController.validarSesion(token, request);
		return "Estudiante/indexEstudiante";
	}
}
