package com.projet.pfa.controllers;

import com.projet.pfa.collections.User;
import com.projet.pfa.repositories.UserRepository;
import com.projet.pfa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}
