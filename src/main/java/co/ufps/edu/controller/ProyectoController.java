package co.ufps.edu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.ufps.edu.dao.Evaluacion;
import co.ufps.edu.dao.LineaDao;
import co.ufps.edu.dao.ProyectoDao;
import co.ufps.edu.dao.TutorDao;
import co.ufps.edu.model.Archivo;
import co.ufps.edu.model.Evaluador;
import co.ufps.edu.model.Proyecto;
import co.ufps.edu.model.ProyectoR;
import co.ufps.edu.util.JwtUtil;

@Controller
public class ProyectoController {

	@Autowired
	private LogController logController;
	private ProyectoDao proyectoDao = new ProyectoDao();
	private LineaDao lineaDao = new LineaDao();
	private TutorDao tutorDao = new TutorDao();
	private JwtUtil jwtUtil = new JwtUtil();

	@GetMapping("/registrarProyecto") // Path para el link
	public String registration(Model model, @RequestParam("t") String token, HttpServletRequest request,
			ModelMap modelMap) {
		logController.validarSesion(token, request);
		initModel(model);
		modelMap.addAttribute("pro", new Proyecto());
		return "Estudiante/RegistrarProyecto"; // Nombre Pagina JSP
	}

	private void initModel(Model model) {
		model.addAttribute("lineas", lineaDao.getLineas());
		model.addAttribute("docentes", tutorDao.getTutores());

	}

	@ModelAttribute("proyecto")
	public Proyecto setUpUserForm() {
		return new Proyecto();
	}

	@ModelAttribute("evaluacion")
	public Evaluacion getEvaluacion() {
		return new Evaluacion();
	}

	@PostMapping(value = "/guardarProyecto", headers = ("content-type=multipart/*"))
	public String guardarProyecto(@ModelAttribute("pro") Proyecto proyecto, @RequestParam("file") MultipartFile file,
			Model model, @RequestParam("t") String token, HttpServletRequest request) {
		if (proyecto.isValidoParaRegistrar(file)) {
			logController.validarSesion(token, request);
			proyectoDao.registrarProyecto(proyecto, proyecto.getCod(), file);
			model.addAttribute("result", "registroExitoso");
			initModel(model);
			model.addAttribute("pro", new Proyecto());
			return "Estudiante/RegistrarProyecto";
		} else {
			logController.validarSesion(token, request);
			model.addAttribute("wrong", "registro");
			initModel(model);
			return "Estudiante/RegistrarProyecto";
		}
		// return "redirect:/registrarProyecto";
	}

	@GetMapping("/calificarProyectos") // Path para el link
	public String calificarProyectos(Model model, @RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);
		return "Administrador/CalificarProyecto"; // Nombre Pagina JSP
	}

	

	@GetMapping("/asignarHorarios") // Path para el link
	public String asignarhorarios(Model model, @RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);		
		return "Administrador/AsignarHorario"; // Nombre Pagina JSP
	}

	@PostMapping("/asignarHorario")
	public String asignarHorario(@RequestParam("file") MultipartFile file,
			Model model, @RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);
		model.addAttribute("result", "registroExitoso");
		proyectoDao.asignarHorario(file);
		return "Administrador/AsignarHorario";
	}

	@GetMapping("/evaluarPro") // Path para el link
	public String evaluarProy(Model model, @RequestParam("id") int idProyecto, @RequestParam("t") String token,
			HttpServletRequest request) {
		logController.validarSesion(token, request);
		model.addAttribute("idProyecto", idProyecto);
		return "Evaluador/EvaluarProyecto"; // Nombre Pagina JSP
	}

	@GetMapping("/evaluarProyectos") // Path para el link
	public String evaluarProyectos(Model model, @RequestParam("cod") String codigo, @RequestParam("t") String token,
			HttpServletRequest request) {
		logController.validarSesion(token, request);
		List<ProyectoR> list = proyectoDao.getProyectosPorEvaluador(String.valueOf(codigo));
		model.addAttribute("list", list);
		return "Evaluador/EvaluarProyectos"; // Nombre Pagina JSP
	}

	@PostMapping("/evaluarProyecto")
	public String EvaluarProyecto(@ModelAttribute("evaluacion") Evaluacion evaluacion,
			@RequestParam("codigoP") String idProyecto, @RequestParam("t") String token,
			@RequestParam("codigoEvaluador") String codigoEvaluador, HttpServletRequest request, Model model) {
		if (evaluacion.validarDatos(idProyecto)) {
			logController.validarSesion(token, request);
			evaluacion.setCodigoProyecto(idProyecto);
			proyectoDao.evaluarProyecto(evaluacion);
			List<ProyectoR> list = proyectoDao.getProyectosPorEvaluador(String.valueOf(codigoEvaluador));
			model.addAttribute("list", list);
			model.addAttribute("result", "registroExitoso");
			return "Evaluador/EvaluarProyectos";
		} else {
			logController.validarSesion(token, request);
			model.addAttribute("idProyecto", idProyecto);
			model.addAttribute("wrong", "registro");
			return "Administrador/EvaluarProyecto";
		}

	}

	@GetMapping("/visualizarProyectos") // Path para el link
	public String visualizarProyectos(Model model, @RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);
		// initModel(model);
		return "Evaluador/VisualizarProyecto"; // Nombre Pagina JSP
	}

	@PostMapping("/visualizarProyecto")
	public String visualizarProyecto(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		return "Evaluador/VisualizarProyecto";
	}

	@GetMapping("/verProyectos") // Path para el link
	public ModelAndView verProyectos(Model model, @RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);
		List<ProyectoR> list = proyectoDao.getProyectos(jwtUtil.parseToken(token) + "");
		model.addAttribute("list", list);
		return new ModelAndView("Estudiante/VerProyectos", "list", list); // Nombre Pagina JSP
	}

	@GetMapping("/asignarProyectos") // Path para el link
	public String asignarProyectos(Model model, @RequestParam("t") String token, HttpServletRequest request) {
		logController.validarSesion(token, request);
		List<ProyectoR> list = proyectoDao.getProyectos();
		model.addAttribute("list", list);
		return "Administrador/AsignarProyecto"; // Nombre Pagina JSP
	}

	
	@GetMapping("/descargarHorario") // Path para el link
	public void asignarProyectos(HttpServletResponse response) {
		Archivo a = proyectoDao.getHorario();
		response.setBufferSize(8192 * 16); 
		response.setContentType("application/octet-stream");
		ServletOutputStream ouputStream = null;
        	
			try {
				System.out.println("tam --> "+(IOUtils.toByteArray(a.getContenido()).length));
				response.setContentLength(IOUtils.toByteArray(a.getContenido()).length);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.setHeader("Content-Disposition","attachment; filename=\"" + a.getNombre() +"\"");
	        try {
				FileCopyUtils.copy(a.getContenido(), response.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
