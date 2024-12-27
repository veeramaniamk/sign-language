package com.saveetha.sign_language.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saveetha.sign_language.model.Users;
import com.saveetha.sign_language.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody Users user) {
        Map<String, Object> response = new HashMap<>();
        if(userService.checkUsersExist(user)) {
            response.put("status", 409);
            response.put("message", "User Already Exist");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        user.setUsertype(100);
        userService.saveUser(user);
        response.put("status", 200);
        response.put("message", "Account Created Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String email, @RequestParam String password) {
        Map<String, Object> response = new HashMap<>();
        Users data = userService.findUserByEmail(email);
        if(data == null) {
            response.put("status", 404);
            response.put("message", "User Not Found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        if(!data.getPassword().equals(password)) {
            response.put("status", 400);
            response.put("message", "Incorrect Password");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        
        
        response.put("status", 200);
        response.put("message", "Login Success");
        response.put("userId", data.getId());
        response.put("name", data.getName());
        response.put("email", data.getEmail());
        response.put("usertype", data.getUsertype());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}