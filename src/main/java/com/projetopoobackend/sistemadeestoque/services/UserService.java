package com.projetopoobackend.sistemadeestoque.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.projetopoobackend.sistemadeestoque.domain.User;
import com.projetopoobackend.sistemadeestoque.dto.UserRegisterDTO;



public interface UserService extends UserDetailsService{

	public User guardar(UserRegisterDTO registerDTO);
	
	public List<User> listarUsuarios();
	
}