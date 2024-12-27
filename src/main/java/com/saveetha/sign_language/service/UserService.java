package com.saveetha.sign_language.service;

import com.saveetha.sign_language.model.Users;
import com.saveetha.sign_language.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public boolean checkUsersExist(Users user) {
        return userRepository.existsByEmail(user.getEmail());
    }

    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}