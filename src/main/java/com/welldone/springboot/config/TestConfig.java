package com.welldone.springboot.config;

import com.welldone.springboot.model.Order;
import com.welldone.springboot.model.OrderStatus;
import com.welldone.springboot.model.User;
import com.welldone.springboot.repository.OrderRepository;
import com.welldone.springboot.repository.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Wesley", "www@gmail.com", "2222222", "12345");
        User u2 = new User(null, "Felipe", "yyy@gmail.com", "4444444", "12345");
        Order o1 = new Order(null,  Instant.now(), u1 , OrderStatus.PAID);
        userRepo.saveAll(Arrays.asList(u1, u2));
        orderRepo.save(o1);


    }
}
