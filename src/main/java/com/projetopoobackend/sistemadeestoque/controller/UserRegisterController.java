package com.projetopoobackend.sistemadeestoque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetopoobackend.sistemadeestoque.dto.UserRegisterDTO;
import com.projetopoobackend.sistemadeestoque.services.UserService;

@Controller
@RequestMapping("/register")
public class UserRegisterController {

	private UserService userService;

	public UserRegisterController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegisterDTO returnNewUserRegisterDTO() {
		return new UserRegisterDTO();
	}

	@GetMapping
	public String mostrarForumalrioDeRegistro() {  //formulario de registro
		return "register";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisterDTO registerDTO) {
		userService.guardar(registerDTO);
		return "redirect:/register?success";
	}
}
