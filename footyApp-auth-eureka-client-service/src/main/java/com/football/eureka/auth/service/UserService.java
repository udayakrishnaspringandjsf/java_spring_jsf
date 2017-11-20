package com.football.eureka.auth.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.eureka.auth.entity.UserEntity;

public interface UserService extends JpaRepository<UserEntity, Integer> {
 UserEntity findByEmail(String email);
}
