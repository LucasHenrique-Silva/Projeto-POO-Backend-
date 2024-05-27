package com.projetopoobackend.sistemadeestoque.config;

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

      

    }

}
