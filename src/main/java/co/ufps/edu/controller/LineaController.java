package co.ufps.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.LineaDao;
import co.ufps.edu.model.Linea;

@Controller
public class LineaController {

	private LineaDao lineaDao = new LineaDao();

	// Devuelve el jsp
	@GetMapping("/registrarLinea") // Path para el link
	public String registration() {
		return "Administrador/RegistrarLineas";
	}

	@ModelAttribute("linea")
	public Linea setUpUserForm() {
		return new Linea();
	}

	@PostMapping("/guardarLinea")
	public String guardarLinea(@ModelAttribute("linea") Linea linea, Model model) {
		lineaDao.registrarLineas(linea);
		return "Administrador/RegistrarLineas";
	}
}
