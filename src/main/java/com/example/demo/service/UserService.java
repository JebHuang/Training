package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Transactional
    public void add(User user) {
        userRepository.save(user);
        // 引发异常
        // int i = 1 / 0;
    }
}
