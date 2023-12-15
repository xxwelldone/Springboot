package com.welldone.springboot.controller;

import com.welldone.springboot.model.Order;
import com.welldone.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderRepo;

   @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok().body(orderRepo.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findbyId(@PathVariable Long id){
        return ResponseEntity.ok().body(orderRepo.findById(id));
    }
}
