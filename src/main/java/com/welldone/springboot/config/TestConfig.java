package com.welldone.springboot.config;

import com.welldone.springboot.model.Category;
import com.welldone.springboot.model.Order;
import com.welldone.springboot.model.OrderStatus;
import com.welldone.springboot.model.User;
import com.welldone.springboot.repository.CategoryRepository;
import com.welldone.springboot.repository.OrderRepository;
import com.welldone.springboot.repository.UserRepository;
import com.welldone.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private CategoryService cs;
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Wesley", "www@gmail.com", "2222222", "12345");
        User u2 = new User(null, "Felipe", "yyy@gmail.com", "4444444", "12345");
        Order o1 = new Order(null,  Instant.now(), u1 , OrderStatus.PAID);
        Category c1 = new Category(null, "Eletronic");
        Category c2 = new Category(null, "Beauty");
        userRepo.saveAll(Arrays.asList(u1, u2));
        orderRepo.save(o1);
        categoryRepo.saveAll(Arrays.asList(c1,c2));


    }
}
