package com.projetopoobackend.sistemadeestoque.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetopoobackend.sistemadeestoque.domain.Product;
import com.projetopoobackend.sistemadeestoque.dto.ProductDto;
import com.projetopoobackend.sistemadeestoque.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<Product> list = service.findAll();
        List<ProductDto> listDto = list.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable String id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(new ProductDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ProductDto objDto) {
        Product obj = service.fromDto(objDto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
