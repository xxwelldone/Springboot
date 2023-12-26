package com.welldone.springboot.service;

import com.welldone.springboot.model.Product;
import com.welldone.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findbyId(Long id){
        return productRepository.findById(id).orElse(
                new Product(null,
                        null,
                        "Product not found",
                        null,
                        null));
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public List<Product> findAllByNameContainingIgnoreCase(String produto){
        return productRepository.findAllByNameContainingIgnoreCase(produto);
    }
}
