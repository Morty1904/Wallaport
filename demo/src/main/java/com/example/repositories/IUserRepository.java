package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, Long>{ 
    
}
