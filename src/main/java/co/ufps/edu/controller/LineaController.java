package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.LineaDao;
import co.ufps.edu.model.Linea;

@Controller
public class LineaController {

	@Autowired
	private LogController logController;
	private LineaDao lineaDao = new LineaDao();

	// Devuelve el jsp
	@GetMapping("/registrarLinea") // Path para el link
	public String registration(@RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);
		return "Administrador/RegistrarLineas";
	}

	@ModelAttribute("linea")
	public Linea setUpUserForm() {
		return new Linea();
	}

	@PostMapping("/guardarLinea")
	public String guardarLinea(@ModelAttribute("linea") Linea linea, Model model, @RequestParam("t") String token,
			HttpServletRequest request) {
		logController.validarSesion(token, request);
		lineaDao.registrarLineas(linea);
		model.addAttribute("linea",new Linea());
		model.addAttribute("result","Resultado exitoso.");
		return "Administrador/RegistrarLineas";
	}
}
