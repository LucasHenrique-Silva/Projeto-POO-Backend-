package com.projetopoobackend.sistemadeestoque.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetopoobackend.sistemadeestoque.domain.User;
import com.projetopoobackend.sistemadeestoque.domain.UserRole;
import com.projetopoobackend.sistemadeestoque.dto.UserRegisterDTO;
import com.projetopoobackend.sistemadeestoque.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;

	}

	@Override
	public User guardar(UserRegisterDTO registerDTO) {
		// Codifica a senha usando o BCryptPasswordEncoder
		String encodedPassword = bCryptPasswordEncoder().encode(registerDTO.getPassword());

		// Cria um novo usuário com a senha codificada
		User user = new User(registerDTO.getName(), registerDTO.getEmail(), encodedPassword,
				Arrays.asList(new UserRole("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario ou senha inválidos");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				mapearAutoridadesRoles(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<UserRole> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public List<User> listarUsuarios() {
		return userRepository.findAll();
	}
}