package com.viagem.security;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {

//    @Autowired
//	private CreateUserService userService;

//	@GetMapping({"/", "/home"})
//	public String home() {
//		return "index";
//	}
//	
//	@RequestMapping("/login")
//	public String login() {
//		return "login";
//	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/usuario")
	public String usuario() {
		return "Hello usuario";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "Hello admin";
	}

//	@GetMapping("/register")
//	public String register() {
//		return "registration";
//	}
//
//	@PostMapping("/createUser")
//	public String createuser(@ModelAttribute User user, HttpSession session) {
//
//			User usuario = userService.execute(user);
//			if (usuario != null) {
//				session.setAttribute("msg", "Register Sucessfully");
//			} else {
//				session.setAttribute("msg", "Something wrong on server");
//			}
//
//		return "redirect:/register";
//	}
}
