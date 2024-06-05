package com.projetopoobackend.sistemadeestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetopoobackend.sistemadeestoque.domain.User;
import com.projetopoobackend.sistemadeestoque.dto.UserDto;
import com.projetopoobackend.sistemadeestoque.repository.UserRepository;
import com.projetopoobackend.sistemadeestoque.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
    private UserRepository repo;
	
	 public List<User> findAll() {
	        return repo.findAll();
	    }
	 
	 public User findById(String id) {
	        Optional<User> obj = repo.findById(id);
	        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	    }

	    public User insert(User obj) {
	        return repo.insert(obj);
	    }

	    public void delete(String id) {
	        findById(id);
	        repo.deleteById(id);
	    }
	    
	    public User update(User obj) {
	        User newUser= findById(obj.getId());
	        updateData(newUser, obj);
	        return repo.save(newUser);
	    }

	    public void updateData(User objUser, User obj) {
	        objUser.setName(obj.getName());
	        objUser.setEmail(obj.getEmail());
	        objUser.setPassword(obj.getPassword());
	        objUser.setRole(obj.getRole());
	        
	    }
	    
	    public User fromDto(UserDto objDto) {
	        return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getPassword(),
	                objDto.getRole());
	    }
	 

}
