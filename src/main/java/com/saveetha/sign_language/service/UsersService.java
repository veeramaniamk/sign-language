package com.saveetha.sign_language.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saveetha.sign_language.model.Users;

@Service
public class UsersService {

    @Autowired
    private UserService userService;

    public Users saveUser(Users user) {
        return userService.saveUser(user);
    }
}