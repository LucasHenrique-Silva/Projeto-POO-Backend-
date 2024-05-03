package com.projetopoobackend.sistemadeestoque.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Configuration;

import com.projetopoobackend.sistemadeestoque.domain.Product;
import com.projetopoobackend.sistemadeestoque.repository.ProductRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        productRepository.deleteAll();

        Product arroz = new Product(null, "Arroz", 10, "Alimentos", 12.5, 15.0, "Sala 2");
        Product feijao = new Product(null, "Feijao", 10, "Alimentos", 15.0, 20.0, "Sala 1");

        productRepository.save(arroz);
        productRepository.save(feijao);

    }

}
