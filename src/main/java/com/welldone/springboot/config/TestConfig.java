package com.welldone.springboot.config;

import com.welldone.springboot.model.*;
import com.welldone.springboot.repository.*;
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
    private ProductRepository productRepo;
    @Autowired
    private CategoryService cs;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Wesley", "www@gmail.com", "2222222", "12345");
        User u2 = new User(null, "Felipe", "yyy@gmail.com", "4444444", "12345");
        Order o1 = new Order(null,  Instant.now(), u1 , OrderStatus.PAID);
        Category c1 = new Category(null, "Eletronic");
        Category c2 = new Category(null, "Beauty");
        Category c3 = new Category(null, "Computers");
        Product p1 = new Product(null, "TV",
                "Samsung TV 69 inches",
                2.500,
                "https://www.shutterstock.com/image-photo/tv-flat-screen-lcd-plasma-260nw-314401364.jpg");
        Product p2 = new Product(null,
                "Celular",
                "Telefone",
                5.600,
                null);
        userRepo.saveAll(Arrays.asList(u1, u2));
        orderRepo.save(o1);
        categoryRepo.saveAll(Arrays.asList(c1,c2,c3));
        p1.getCategories().add(c1);
        p1.getCategories().add(c3);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        productRepo.saveAll(Arrays.asList(p1,p2));

        OrderItems oi1 = new OrderItems(o1,p1,3, p1.getPrice());
        OrderItems oi2 = new OrderItems(o1, p2,1, p2.getPrice());

    orderItemRepository.saveAll(Arrays.asList(oi1,oi2));
        Order o2 = new Order(null,  Instant.now(), u1 , OrderStatus.PAID);
        o2.setPayment(new Payment(null, Instant.now(), o2));
        orderRepo.save(o2);

    }
}
