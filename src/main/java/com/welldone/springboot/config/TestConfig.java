package com.welldone.springboot.config;

import com.welldone.springboot.model.User;
import com.welldone.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Wesley", "www@gmail.com", "2222222", "12345");
        User u2 = new User(null, "Felipe", "yyy@gmail.com", "4444444", "12345");

        userRepo.saveAll(Arrays.asList(u1, u2));


    }
}
