package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@PostMapping("/guardarEstudiante")
	public String registrarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante, Model model) {

		
		if (esCodigoValido()) {
		}

		boolean result = estudianteDao.registrarEstudiante(estudiante);
	/*	if (result) {
			model.addAttribute("sw", "true");
			model.addAttribute("titleMessage", "Registro exitoso");
			model.addAttribute("message", "El estudiante ha sido registrado exitosamente.");
		} else {
			model.addAttribute("sw", 3);
			model.addAttribute("titleMessage", "Registro fallido");
			model.addAttribute("message", "El estudiante no ha sido registrado.");
		}*/

		return "RegistrarEstudiante";
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
