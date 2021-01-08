package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Setter
@Getter
@ToString
public class AdminUser {
    private String userId;
    private String username;
    private String email;
    private String lastname;
    private String firstname;
    private String realmName;
    private Set<String> roles;
}
