package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.EvaluadorDao;
import co.ufps.edu.model.Evaluador;

@Controller
public class EvaluadorController {

	private EvaluadorDao evaluadorDao = new EvaluadorDao();

	@GetMapping("/registrarEvaluador") // Path para el link
	public String registration() {
		return "Administrador/RegistrarEvaluador";
	}

	@ModelAttribute("evaluador")
	public Evaluador setUpUserForm() {
		return new Evaluador();
	}

	@PostMapping("/guardarEvaluadores")
	public String RegistrarEvaluador(@ModelAttribute("evaluador") Evaluador e, Model model) {

		evaluadorDao.registrarEvaluador(e);

		return "RegistrarEvaluador";
	}

	@PostMapping("/evaluarProyecto")
	public String evaluarProyecto(int idProyecto, int idEvaluador) {

		// Implement business logic to save user details into a database
		// .....

		// model.asMap()
		/*
		 * System.out.println("FirstName : " + estudiante.getCodigo());
		 * System.out.println("FirstName : " + estudiante.getNombre());
		 * System.out.println("FirstName : " + estudiante.getApellido());
		 * System.out.println("FirstName : " + estudiante.getEmail());
		 */

		// model.addAttribute("message", "User saved successfully.");

		return "EvaluarProyectos";
	}

	@PostMapping("/asignarProyecto")
	public String AsignarProyectos(@ModelAttribute("evaluador") Evaluador evaluador, Model model) {

		// Implement business logic to save user details into a database
		// .....

		model.addAttribute("message", "User saved successfully.");

		return "AsignarProyecto";
	}

}
