package com.projetopoobackend.sistemadeestoque.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetopoobackend.sistemadeestoque.domain.User;
import com.projetopoobackend.sistemadeestoque.dto.UserDto;
import com.projetopoobackend.sistemadeestoque.services.UserService;


@RestController
//@RequestMapping(value = "/user")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	 @PostMapping(value = "/insertuser")
	    public ResponseEntity<User> insert(@RequestBody UserDto objDto) {
	        User obj = service.fromDto(objDto);
	        obj =  service.insert(obj);
	        
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	        
	        return ResponseEntity.created(uri).body(obj);
	    }
	    
	    @GetMapping(value = "removeuser/{id}")
	    public ModelAndView  delete(@PathVariable String id) {
	        service.delete(id);
	        ModelAndView mav = new ModelAndView("redirect:/products");
	        return mav;
	    }
	    
	    
	    @PostMapping(value = "/editUser")
	    public ModelAndView update( UserDto objDto) {
	    	
	        User obj = service.fromDto(objDto);
	        
	        obj.setId(objDto.getId());
	        obj = service.update(obj);
	       
	        ModelAndView mav = new ModelAndView("redirect:/products");
	        return mav;
	    }
	    
	    //frontEnd
	    
	    @GetMapping("/login")
	    public ModelAndView logar(User user) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("user/login");
	        modelAndView.addObject("user", new User());
	        return modelAndView;
	    }
	    
	    @GetMapping("/cadastro")
	    public ModelAndView cadaster(User user) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("user/cadastrar");
	        modelAndView.addObject("user", new User());
	        return modelAndView;
	    }
	    
	    @RequestMapping("/{path:[^\\.]+}/**")
	    public ModelAndView forward(User user) {
	        ModelAndView model = new ModelAndView();
	        model.setViewName("user/login");
	        model.addObject("user", new User());
	        return model;
	    }
	    @GetMapping("/")
	    public ModelAndView home() {
	        ModelAndView model = new ModelAndView();
	        model.setViewName("user/login");
	        return model;
	    }
	   
}
