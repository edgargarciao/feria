package co.ufps.edu.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.ufps.edu.dao.LineaDao;
import co.ufps.edu.dao.ProyectoDao;
import co.ufps.edu.dao.TutorDao;
import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.Proyecto;
import co.ufps.edu.util.JwtUtil;

@Controller
public class ProyectoController {

	@Autowired
	private LogController logController;
	private ProyectoDao proyectoDao = new ProyectoDao();
	private LineaDao lineaDao = new LineaDao();
	private TutorDao tutorDao = new TutorDao();

	@GetMapping("/registrarProyecto") // Path para el link
	public String registration(Model model, @RequestParam("t") String token, HttpServletRequest request,ModelMap modelMap) {
		logController.validarSesion(token, request);
		initModel(model);
		modelMap.addAttribute("pro",new Proyecto());
		return "Estudiante/RegistrarProyecto"; // Nombre Pagina JSP
	}

	private void initModel(Model model) {
		model.addAttribute("lineas", lineaDao.getLineas());
		model.addAttribute("docentes",tutorDao.getTutores());
		
		
	}

	@ModelAttribute("proyecto")
	public Proyecto setUpUserForm() {
		return new Proyecto();
	}

	@PostMapping(value="/guardarProyecto")
	public String guardarProyecto(@ModelAttribute("pro") Proyecto proyecto, 
			 @RequestParam("file") MultipartFile file,
			Model model,
			//@RequestParam("t") String token,
			HttpServletRequest request) {
		System.out.println("en");
		//logController.validarSesion(token,request);
		proyectoDao.registrarProyecto(proyecto,115,file);
		return "Estudiante/RegistrarProyecto";
	}

	@GetMapping("/calificarProyectos") // Path para el link
	public String calificarProyectos(Model model, @RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		// initModel(model);
		return "Administrador/CalificarProyecto"; // Nombre Pagina JSP
	}

	@PostMapping("/calificarProyecto")
	public String calificarProyecto(int idProyecto, int idEvaluador) {
		return "Administrador/CalificarProyecto";
	}

	@GetMapping("/asignarHorarios") // Path para el link
	public String asignarhorarios(Model model, @RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		// initModel(model);
		return "Administrador/AsignarHorario"; // Nombre Pagina JSP
	}

	@PostMapping("/asignarHorario")
	public String asignarHorario(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		return "Administrador/AsignarHorario";
	}

	@GetMapping("/evaluarProyectos") // Path para el link
	public String evaluarProyectos(Model model,  @RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		// initModel(model);
		return "Evaluador/EvaluarProyecto"; // Nombre Pagina JSP
	}

	@PostMapping("/evaluarProyecto")
	public String EvaluarProyecto(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		return "Evaluador/EvaluarProyecto";
	}

	@GetMapping("/visualizarProyectos") // Path para el link
	public String visualizarProyectos(Model model,  @RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		// initModel(model);
		return "Evaluador/VisualizarProyecto"; // Nombre Pagina JSP
	}

	@PostMapping("/visualizarProyecto")
	public String visualizarProyecto(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		return "Evaluador/VisualizarProyecto";
	}
	
	@GetMapping("/verProyectos") // Path para el link
	public String verProyectos(Model model,  @RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		// initModel(model);
		return "Estudiante/VerProyectos"; // Nombre Pagina JSP
	}
	

	@GetMapping("/asignarProyectos") // Path para el link
	public String asignarProyectos(Model model,@RequestParam("t") String token,HttpServletRequest request) {
		logController.validarSesion(token, request);
		// initModel(model);
		return "Administrador/AsignarProyecto"; // Nombre Pagina JSP
	}
	
	@PostMapping("/asignarProyecto")
	public String AsignarProyecto(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		return "Administrador/AsignarProyecto";
	}
	
	
}
