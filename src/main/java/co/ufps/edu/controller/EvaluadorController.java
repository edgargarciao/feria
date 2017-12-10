package co.ufps.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.ufps.edu.dao.Asignacion;
import co.ufps.edu.dao.EvaluadorDao;
import co.ufps.edu.dao.LineaDao;
import co.ufps.edu.dao.ProyectoDao;
import co.ufps.edu.dao.TutorDao;
import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.Proyecto;
import co.ufps.edu.model.ProyectoR;

@Controller
public class EvaluadorController {

	@Autowired
	private LogController logController;
	private EvaluadorDao evaluadorDao = new EvaluadorDao();
	private LineaDao lineaDao = new LineaDao();
	private ProyectoDao proyectoDao = new ProyectoDao();

	@GetMapping("/registrarEvaluador") // Path para el link
	public String registration(Model model, @RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);
		model.addAttribute("ListaLineas", lineaDao.getLineas().values());
		return "Administrador/RegistrarEvaluador";
	}

	@ModelAttribute("evaluador")
	public Evaluador setUpUserForm() {
		return new Evaluador();
	}

	@PostMapping("/guardarEvaluadores")
	public String RegistrarEvaluador(@ModelAttribute("evaluador") Evaluador e, Model model,
			@RequestParam("t") String token, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (e.validarDatos()) {
			logController.validarSesion(token, request);
			evaluadorDao.registrarEvaluador(e);
			model.addAttribute("ListaLineas", lineaDao.getLineas().values());
			model.addAttribute("result", "registroExitoso");
			model.addAttribute("evaluador", new Evaluador());
			return "Administrador/RegistrarEvaluador";
		} else {
			logController.validarSesion(token, request);
			model.addAttribute("wrong", "registro");
			model.addAttribute("ListaLineas", lineaDao.getLineas().values());
			return "Administrador/RegistrarEvaluador";
		}

	}

	// Devuelve el jsp
	@GetMapping("/indexEvaluador") // Path para el link
	public String getIndex(@RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);
		return "Evaluador/indexEvaluador";
	}

	@GetMapping("/asignarEvaluadores") // Path para el link
	public String getAsignarEvaluadores(Model model, @RequestParam("t") String token, HttpServletRequest request,
			@RequestParam("id") int idProyecto) {
		logController.validarSesion(token, request);
		model.addAttribute("idProyecto", idProyecto);
		model.addAttribute("evaluadores", evaluadorDao.getEvaluadoresPorProyecto(idProyecto));
		return "Administrador/AsignarEvaluadores";
	}

	@ModelAttribute("asignacion")
	public Asignacion getEvaluador() {
		return new Asignacion();
	}

	@PostMapping("/asginarEvaluadoresProyecto")
	public String asignarEvaluador(@ModelAttribute("asignacion") Asignacion asignacion, Model model,
			@RequestParam("codigoP") String codigoP, @RequestParam("t") String token, HttpServletRequest request) {
		if (asignacion.validarDatos()) {
			asignacion.setCodigoProyecto(codigoP);
			logController.validarSesion(token, request);
			evaluadorDao.asignarEvaluador(asignacion);
			List<ProyectoR> list = proyectoDao.getProyectos();
			model.addAttribute("list", list);
			model.addAttribute("result", "registroExitoso");
			return "Administrador/AsignarProyecto";
		} else {
			logController.validarSesion(token, request);
			model.addAttribute("wrong", "registro");
			model.addAttribute("idProyecto", codigoP);
			model.addAttribute("evaluadores",
					evaluadorDao.getEvaluadoresPorProyecto(Integer.parseInt(codigoP)));
			return "Administrador/AsignarEvaluadores";
		}

	}
}
