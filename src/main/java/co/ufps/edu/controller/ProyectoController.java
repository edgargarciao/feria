package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ufps.edu.dao.LineaDao;
import co.ufps.edu.dao.ProyectoDao;
import co.ufps.edu.model.Proyecto;
import co.ufps.edu.util.JwtUtil;

@Controller
public class ProyectoController {

	@Autowired
	private RedisTemplate<String, String> template;
	
	private ProyectoDao proyectoDao = new ProyectoDao();
	private LineaDao lineaDao = new LineaDao();
	private JwtUtil jwtUtil = new JwtUtil();

	@GetMapping("/registrarProyecto") // Path para el link
	public String registration(Model model,HttpServletRequest request) {
		validarSesion(request);
		initModel(model);
		return "Estudiante/RegistrarProyecto"; // Nombre Pagina JSP
	}

	private void initModel(Model model) {
		model.addAttribute("lineas", lineaDao.getLineas());
	}

	@ModelAttribute("proyecto")
	public Proyecto setUpUserForm() {
		return new Proyecto();
	}

	@PostMapping("/guardarProyecto")
	public String guardarProyecto(@ModelAttribute("proyecto") Proyecto proyecto, Model model,HttpServletRequest request) {
		validarSesion(request);
		proyectoDao.registrarProyecto(proyecto);

		return "RegistrarProyecto";
	}

	private void validarSesion(HttpServletRequest request) {
		String token = request.getHeader("token");
		int codigo =  jwtUtil.parseToken(token);
		if(token == null || token.isEmpty() || codigo==0 || template.opsForValue().get("SESSION:"+codigo) == null) {
			throw new RuntimeException("FALTA TOKEN");
		}
	}
	
	@GetMapping("/calificarProyectos") // Path para el link
	public String calificarProyectos(Model model,HttpServletRequest request) {
		// validarSesion(request);
		// initModel(model);
		return "Administrador/CalificarProyecto"; // Nombre Pagina JSP
	}
	
	@PostMapping("/calificarProyecto")
	public String calificarProyecto(int idProyecto, int idEvaluador) {
		return "Administrador/CalificarProyecto";
	}

	@GetMapping("/AsignarHorarios") // Path para el link
	public String asignarhorarios(Model model,HttpServletRequest request) {
		// validarSesion(request);
		// initModel(model);
		return "Administrador/CalificarProyecto"; // Nombre Pagina JSP
	}
	
	@PostMapping("/AsignarHorario")
	public String AsignarHorario(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		return "Administrador/AsignarHorario";
	}

	@GetMapping("/asignarProyectos") // Path para el link
	public String asignarProyectos(Model model,HttpServletRequest request) {
		// validarSesion(request);
		// initModel(model);
		return "Administrador/AsignarProyecto"; // Nombre Pagina JSP
	}
	
	@PostMapping("/AsignarProyecto")
	public String AsignarProyecto(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		return "Administrador/AsignarProyecto";
	}
}
