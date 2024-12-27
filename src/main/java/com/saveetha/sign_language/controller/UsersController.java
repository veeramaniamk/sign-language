package com.saveetha.sign_language.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.saveetha.sign_language.model.Users;
import com.saveetha.sign_language.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Users addUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }
}