package com.example.controller;

import com.example.Model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> foundUser = userService.findByEmail(user.getEmail());
        if (foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }
}