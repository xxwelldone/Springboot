package com.welldone.springboot.service;

import com.welldone.springboot.model.Order;
import com.welldone.springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public Order findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Order> findAll() {
        return repo.findAll();
    }

}
