package com.projetopoobackend.sistemadeestoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.projetopoobackend.sistemadeestoque.domain.Product;
import com.projetopoobackend.sistemadeestoque.dto.ProductDto;
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

    public Product insert(Product obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public Product update(Product obj) {
        Product newProduct = findById(obj.getId());
        updateData(newProduct, obj);
        return repo.save(newProduct);
    }

    public void updateData(Product objProduct, Product obj) {
        objProduct.setName(obj.getName());
        objProduct.setQuantity(obj.getQuantity());
        objProduct.setType(obj.getType());
        objProduct.setBuyPrice(obj.getBuyPrice());
        objProduct.setSellPrice(obj.getSellPrice());
        objProduct.setWhereStored(obj.getWhereStored());
    }

    public Product fromDto(ProductDto objDto) {
        return new Product(objDto.getId(), objDto.getName(), objDto.getQuantity(), objDto.getType(),
                objDto.getBuyPrice(), objDto.getSellPrice(), objDto.getWhereStored());
    }
}
