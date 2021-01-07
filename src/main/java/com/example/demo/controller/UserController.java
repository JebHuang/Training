package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lance
 * @date 2021/1/7 16:59
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("/user/login")
    public void login(@RequestParam(name = "username", required = true) String username,
                      @RequestParam(name = "password", required = true) String password) {

    }
}
