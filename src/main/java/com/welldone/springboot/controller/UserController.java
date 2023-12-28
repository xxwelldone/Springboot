package com.welldone.springboot.controller;

import com.welldone.springboot.model.User;
import com.welldone.springboot.service.UserService;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
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
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User obj = userRepo.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userRepo.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        user = userRepo.update(id, user);
      return ResponseEntity.ok().body(user);
    }
}
