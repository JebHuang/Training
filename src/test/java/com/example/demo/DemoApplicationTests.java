package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        Object obj = userRepository.findAll();
    }

    @Test
    void page() {
//        Sort sort = Sort.by("id").descending();
        Page<User> users = userRepository.findAll(PageRequest.of(0, 1) );
    }


    @Test
    void add() {
        Random random = new Random();
        User user = new User();
        user.setUsername("tom_" + random.nextInt(1000));
        user.setPassword("123456");
        user.setEmail(user.getUsername() + "@ASL.com");
//        userRepository.save(user);
        userService.add(user);
    }

}
