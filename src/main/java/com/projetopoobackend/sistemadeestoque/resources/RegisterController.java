package com.projetopoobackend.sistemadeestoque.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
}