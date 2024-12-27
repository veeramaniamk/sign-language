package com.saveetha.sign_language.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saveetha.sign_language.model.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {
}
