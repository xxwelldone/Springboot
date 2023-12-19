package com.welldone.springboot.controller;

import com.welldone.springboot.model.Category;
import com.welldone.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService catRepo;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok().body(catRepo.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return  ResponseEntity.ok().body(catRepo.findbyId(id));
    }

}
