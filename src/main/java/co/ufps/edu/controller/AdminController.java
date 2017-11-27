package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.model.Administrador;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.Linea;
import co.ufps.edu.model.Proyecto;

@Controller
public class AdminController {
	
	@Autowired
	private LogController logController;

	@ModelAttribute("administrador")
	public Administrador setUpUserForm(@RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		return new Administrador();
	}
	
	// Devuelve el jsp
	@GetMapping("/indexAdmin") // Path para el link
	public String getIndex() {
		return "Administrador/indexAdmin";
	}

}
