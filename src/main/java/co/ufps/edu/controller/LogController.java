package co.ufps.edu.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.LoginDao;
import co.ufps.edu.model.Estudiante;
import co.ufps.edu.model.Login;
import co.ufps.edu.util.JwtUtil;

@Controller
public class LogController {

	@Autowired
	private RedisTemplate<String, String> template;

	private JwtUtil jwtUtil = new JwtUtil();

	private LoginDao loginDao = new LoginDao();

	@GetMapping("/index") // Base
	public String main() {
		return "index"; // Nombre del archivo jsp
	}
	
	@GetMapping("/login") // Base
	public String index() {
		return "Login"; // Nombre del archivo jsp
	}

	@ModelAttribute("login")
	public Login setUpUserForm() {
		return new Login();
	}

	@PostMapping("/autenticar")
	public String authenticateUser(@ModelAttribute("login") Login login, Model model, HttpServletResponse response) {

		String resultado = loginDao.authenticate(login.getCodigo(), login.getContraseña());
		
		if (!resultado.isEmpty()) {
			 String jwt = jwtUtil.generateToken(resultado,
			 String.valueOf(login.getCodigo()));
			 response.setHeader("token",jwt);
			 template.opsForValue().set("SESSION:" + login.getCodigo(), jwt);
			if (resultado.equals("estudiante")) {
				return "Estudiante/indexEstudiante";
			} else if (resultado.equals("evaluador")) {
				return "Evaluador/indexEvaluador";
			} else if (resultado.equals("admin")) {
				return "Administrador/indexAdmin";
			}
		}

		System.out.println("coming in controller    " + login.getCodigo() + " : " + login.getContraseña());		

		// model.addAttribute("message", "Hello Spring MVC Framework!");
		return "indexAdmin";
	}

}
