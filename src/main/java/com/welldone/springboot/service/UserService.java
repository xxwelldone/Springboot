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

    public User save(User user) {
        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public User update(Long id, User user) {
        User updatedUser = repo.getReferenceById(id);
        updateData(updatedUser, user);


        return repo.save(updatedUser);
    }

    private void updateData(User update, User user) {
        update.setEmail(user.getEmail());
        update.setName(user.getName());

        update.setPhone(user.getPhone());
    }

}
