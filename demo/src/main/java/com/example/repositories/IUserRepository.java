package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, Long>{ 
    Optional<UserModel> findByEmail(String email);
}
