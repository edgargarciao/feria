package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("/logout") // Base
	@ResponseBody
	public ModelAndView  logout(@RequestParam("t") String token,HttpServletRequest request ) {	
		getLogOut(token,request);
		return new ModelAndView("index"); // Nombre del archivo jsp
	}

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
	public String authenticateUser(@ModelAttribute("login") Login login, Model model,HttpServletRequest request) {

		String resultado = loginDao.authenticate(login.getCodigo(), login.getContraseña());
		
		if (!resultado.isEmpty()) {
			 String jwt = jwtUtil.generateToken(resultado,
			 String.valueOf(login.getCodigo()));
			 request.setAttribute("token", jwt);
			 HttpSession session = request.getSession();			 
			 template.opsForValue().set("SESSION:" + login.getCodigo(), jwt);
			if (resultado.equals("estudiante")) {
				session.setAttribute("user", "Estudiante");
				return "Estudiante/indexEstudiante";
			} else if (resultado.equals("evaluador")) {
				session.setAttribute("user", "Evaluador");
				return "Evaluador/indexEvaluador";
			} else if (resultado.equals("admin")) {
				session.setAttribute("user", "Administrador");
				return "Administrador/indexAdmin";
			}
		}

		System.out.println("coming in controller    " + login.getCodigo() + " : " + login.getContraseña());		

		model.addAttribute("message", "Hello Spring MVC Framework!");
		
		return "indexAdmin";
	}
	
	public void validarSesion(String token, HttpServletRequest request) {		
		int codigo = jwtUtil.parseToken(token);
		if (token == null || token.isEmpty() || codigo == 0
				|| template.opsForValue().get("SESSION:" + codigo) == null) {
			throw new RuntimeException("FALTA TOKEN");
		}
		request.setAttribute("token", token);
	}
	
	private void getLogOut(String token, HttpServletRequest request) {
		request.getSession().invalidate();
		int codigo = jwtUtil.parseToken(token);
		template.delete("SESSION:" + codigo);		
	}

}
