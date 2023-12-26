package com.welldone.springboot.controller;

import com.welldone.springboot.model.Product;
import com.welldone.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productRepo;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok().body(productRepo.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(productRepo.findbyId(id));
    }
    @GetMapping(value = "titulo/{titulo}")
    public ResponseEntity<List<Product>> findAllByNameContainingIgnore(@PathVariable String titulo){
        return ResponseEntity.ok().body(productRepo.findAllByNameContainingIgnoreCase(titulo));
    }
}
