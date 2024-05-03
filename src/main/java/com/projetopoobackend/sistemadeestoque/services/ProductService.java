package com.projetopoobackend.sistemadeestoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.projetopoobackend.sistemadeestoque.domain.Product;
import com.projetopoobackend.sistemadeestoque.repository.ProductRepository;
import com.projetopoobackend.sistemadeestoque.services.exception.ObjectNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(String id) {
        Optional<Product> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
