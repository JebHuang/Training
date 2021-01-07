package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Random;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private IUserRepository IUserRepository;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        Object obj = IUserRepository.findAll();
    }

    @Test
    void page() {
        Page<User> users = IUserRepository.findAll(PageRequest.of(0, 1) );
    }


    @Test
    void add() {
        Random random = new Random();
        User user = new User();
        user.setUsername("tom_" + random.nextInt(1000));
        user.setPassword("123456");
        user.setEmail(user.getUsername() + "@ASL.com");
        userService.add(user);
    }

    @Test
    void insert() {
        Random random = new Random();
        User user = new User();
        user.setUsername("asl-" + random.nextInt(1000));
        user.setPassword("123456");
        user.setEmail(user.getUsername() + "@ASL.com");
        IUserRepository.save(user);
        System.out.println("-------------------");
    }

}
