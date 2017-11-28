package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.EvaluadorDao;
import co.ufps.edu.dao.LineaDao;
import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.Proyecto;

@Controller
public class EvaluadorController {
	
	@Autowired
	private LogController logController;
	private EvaluadorDao evaluadorDao = new EvaluadorDao();
	private LineaDao lineaDao = new LineaDao();

	@GetMapping("/registrarEvaluador") // Path para el link
	public String registration(Model model, @RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		model.addAttribute("ListaLineas", lineaDao.getLineas().values());
		return "Administrador/RegistrarEvaluador";
	}

	@ModelAttribute("evaluador")
	public Evaluador setUpUserForm() {
		return new Evaluador();
	}
	
	@PostMapping("/guardarEvaluadores")
	public String RegistrarEvaluador(@ModelAttribute("evaluador") Evaluador e, Model model) {
		evaluadorDao.registrarEvaluador(e);
		model.addAttribute("ListaLineas", lineaDao.getLineas().values());
		return "Administrador/RegistrarEvaluador";
	}
	
	// Devuelve el jsp
	@GetMapping("/indexEvaluador") // Path para el link
	public String getIndex(@RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		return "Evaluador/indexEvaluador";
	}
	
	
}
