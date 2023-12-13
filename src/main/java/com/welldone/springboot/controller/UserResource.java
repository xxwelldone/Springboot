package com.welldone.springboot.controller;

import com.welldone.springboot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User x = new User(2L, "xxx", "xxx@gmail.com",
                "88888", "123456");
        return ResponseEntity.ok().body(x);

    }
}
