package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/search")
    public List<User> searchUsersByName(@RequestParam String keyword) {
        return userService.findUsersByNameKeyword(keyword);
    }

    @GetMapping("/email-domain")
    public List<User> getUsersByEmailDomain(@RequestParam String domain) {
        return userService.findUsersByEmailDomain(domain);
    }
}
