package com.welldone.springboot.service;

import com.welldone.springboot.model.User;
import com.welldone.springboot.repository.UserRepository;
import com.welldone.springboot.service.exceptions.DatabaseException;
import com.welldone.springboot.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User findById(Long id) {
        return repo.findById(id).orElseThrow(()->new ResourceNotFoundException(id));

    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User save(User user) {
        return repo.save(user);
    }

    public void delete(Long id) {
        try{
            repo.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException i){
            throw new DatabaseException(i.getMessage());
        }

    }

    public User update(Long id, User user) {
        try{
        User updatedUser = repo.getReferenceById(id);
        updateData(updatedUser, user);
        return repo.save(updatedUser);}
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    private void updateData(User update, User user) {
        update.setEmail(user.getEmail());
        update.setName(user.getName());

        update.setPhone(user.getPhone());
    }

}
