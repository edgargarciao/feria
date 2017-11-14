package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.dao.EstudianteDao;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Proyecto;

@Controller
public class EstudianteController {

	private EstudianteDao estudianteDao = new EstudianteDao();

	// Devuelve el jsp
	@GetMapping("/registrarEstudiante") // Path para el link
	public String registration(HttpServletRequest request) {
		request.getSession().setAttribute("sw", false);
		request.getSession().setAttribute("titleMessage", "");
		request.getSession().setAttribute("message", "");
		return "RegistrarEstudiante";
	}

	@ModelAttribute("estudiante")
	public Estudiante setUpUserForm() {
		return new Estudiante();
	}

	@PostMapping("/guardarEstudiante")
	public String registrarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante, Model model) {

		// Implement business logic to save user details into a database
		// .....
		
		System.out.println("FirstName : " + estudiante.getCodigo());
		System.out.println("FirstName : " + estudiante.getNombre());
		System.out.println("FirstName : " + estudiante.getApellido());
		System.out.println("FirstName : " + estudiante.getEmail());

		if (esCodigoValido()) {
		}

		boolean result = estudianteDao.registrarEstudiante(estudiante);
		if (result) {
			model.addAttribute("sw", "true");
			model.addAttribute("titleMessage", "Registro exitoso");
			model.addAttribute("message", "El estudiante ha sido registrado exitosamente.");
		} else {
			model.addAttribute("sw", 3);
			model.addAttribute("titleMessage", "Registro fallido");
			model.addAttribute("message", "El estudiante no ha sido registrado.");
		}

		return "RegistrarEstudiante";
	}

	private boolean esCodigoValido() {
		return true;
	}
}
