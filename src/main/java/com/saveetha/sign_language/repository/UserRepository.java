package com.saveetha.sign_language.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saveetha.sign_language.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    boolean existsByEmail(String email);

    // Users findByEmail(String email);
    Users findByEmail(String email);


}