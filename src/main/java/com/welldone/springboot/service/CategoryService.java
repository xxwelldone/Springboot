package com.welldone.springboot.service;

import com.welldone.springboot.model.Category;
import com.welldone.springboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> findAll(){
        return categoryRepo.findAll();
    }
    public Category findbyId(Long id){
        return categoryRepo.findById(id).orElse(new Category(null, "No CATEGORY FOUND"));
    }
}
