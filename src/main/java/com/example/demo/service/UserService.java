package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserService {
    @Resource
    private IUserRepository IUserRepository;

    @Transactional
    public void add(User user) {
        IUserRepository.save(user);
    }
}
