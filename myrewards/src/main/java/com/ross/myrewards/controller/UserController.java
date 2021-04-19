package com.ross.myrewards.controller;

import com.ross.myrewards.model.User;
import com.ross.myrewards.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("by-id")
    public Optional<User> getUserById(@RequestParam Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("by-email")
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

}
