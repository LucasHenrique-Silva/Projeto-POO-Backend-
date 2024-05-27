package com.projetopoobackend.sistemadeestoque.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetopoobackend.sistemadeestoque.domain.Product;
import com.projetopoobackend.sistemadeestoque.dto.ProductDto;
import com.projetopoobackend.sistemadeestoque.repository.ProductRepository;
import com.projetopoobackend.sistemadeestoque.services.ProductService;



@RestController
//@RequestMapping(value = "/products")
public class ProductResource {

	
	
    @Autowired
    private ProductService service;

    //Rotas BackEnd
    
    @PostMapping(value = "/insertproducts")
    public ModelAndView insert( ProductDto objDto) {
        Product obj = service.fromDto(objDto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        ModelAndView mav = new ModelAndView("redirect:/products");
        return mav;
    }
    
    @GetMapping(value = "remove/{id}")
    public ModelAndView  delete(@PathVariable String id) {
        service.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/products");
        return mav;
    }
    
    
    @PostMapping(value = "/editProduct")
    public ModelAndView update( ProductDto objDto) {
    	
        Product obj = service.fromDto(objDto);
        
        obj.setId(objDto.getId());
        obj = service.update(obj);
       
        ModelAndView mav = new ModelAndView("redirect:/products");
        return mav;
    }
   
    //Rotas FrontEnds
    @GetMapping("/products")
    public ModelAndView producs(Product product) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/products/products");
        model.addObject("products", service.findAll());
        return model;
    }
    
    @GetMapping("/inserirproduto")
    public ModelAndView insertAlunos(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products/formProduct");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("products/index");
        return model;
    }
    
    @GetMapping("/editProduct/{id}")
    public ModelAndView editarProduto(@PathVariable("id") String id) {
        ModelAndView model = new ModelAndView();
        Product produto = service.findById(id); // Substitui findById por buscarPorId (mais descritivo)
       
        model.addObject("product", produto);
        model.setViewName("products/editProduct");
        return model;
    }

}
