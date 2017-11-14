package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.LineaDao;
import co.ufps.edu.dao.ProyectoDao;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Proyecto;

@Controller
public class ProyectoController {

	private ProyectoDao proyectoDao = new ProyectoDao();
	private LineaDao lineaDao = new LineaDao();

	@GetMapping("/registrarProyecto") // Path para el link
	public String registration(Model model) {
		initModel(model);
		return "RegistrarProyecto"; // Nombre Pagina JSP
	}

	private void initModel(Model model) {
		model.addAttribute("lineas", lineaDao.getLineas());
	}

	@ModelAttribute("proyecto")
	public Proyecto setUpUserForm() {
		return new Proyecto();
	}

	@PostMapping("/guardarProyecto")
	public String guardarProyecto(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {

		proyectoDao.registrarProyecto(proyecto);

		return "RegistrarProyecto";
	}

}
