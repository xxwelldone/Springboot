package com.welldone.springboot.service;

import com.welldone.springboot.model.User;
import com.welldone.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User findById(Long id) {
        return repo.findById(id).orElse(new User(null, "No user found", null, null, null));

    }

    public List<User> findAll() {
        return repo.findAll();
    }

}
