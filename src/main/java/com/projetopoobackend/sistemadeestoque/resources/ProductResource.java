package com.projetopoobackend.sistemadeestoque.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetopoobackend.sistemadeestoque.domain.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        Product arroz = new Product("1", "Arroz com ovo", 10, "Comida", 12.50, 15.90, "Sala 2");
        Product feijao = new Product("2", "Feijão", 20, "Comida", 10.00, 12.30, "Sala 2");
        List<Product> list = new ArrayList<>();
        list.addAll(Arrays.asList(arroz, feijao));
        return ResponseEntity.ok().body(list);
    }
}
