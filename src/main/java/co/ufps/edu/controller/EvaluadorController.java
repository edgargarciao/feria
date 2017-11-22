package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.EvaluadorDao;
import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.Proyecto;

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

	@GetMapping("/asignarProyectos") // Path para el link
	public String asignarProyectos(Model model,HttpServletRequest request) {
		// validarSesion(request);
		// initModel(model);
		return "Administrador/AsignarProyecto"; // Nombre Pagina JSP
	}
	
	@PostMapping("/asignarProyecto")
	public String AsignarProyecto(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		return "Administrador/AsignarProyecto";
	}
	@PostMapping("/guardarEvaluadores")
	public String RegistrarEvaluador(@ModelAttribute("evaluador") Evaluador e, Model model) {

		evaluadorDao.registrarEvaluador(e);

		return "RegistrarEvaluador";
	}
	
	// Devuelve el jsp
	@GetMapping("/indexEvaluador") // Path para el link
	public String getIndex() {
		return "Evaluador/indexEvaluador";
	}
}
