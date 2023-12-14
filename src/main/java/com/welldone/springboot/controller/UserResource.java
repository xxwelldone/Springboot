package com.welldone.springboot.controller;

import com.welldone.springboot.model.User;
import com.welldone.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService userRepo;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> response = userRepo.findAll();
        return ResponseEntity.ok().body(response);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User response = userRepo.findById(id);
        return ResponseEntity.ok().body(response);
    }
}
