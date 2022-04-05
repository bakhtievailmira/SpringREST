package com.example.springrest.controller;

import com.example.springrest.exceptions.NoSuchUserException;
import com.example.springrest.model.Role;
import com.example.springrest.model.User;
import com.example.springrest.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {
    private UserService userService;

    public RESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> showUserList() {
        return userService.findAll();
    }


    @GetMapping("/users/{id}")
    public User showUser(@PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with ID = " + id);
        } else {
            return user;
        }
    }

    @PostMapping("/users")
    public User addUser(@ModelAttribute User user) {
        userService.save(user);
        return user;
    }

    @PutMapping("/users/{id}")
    public User updateUser(@ModelAttribute User user) {
        userService.save(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with ID = " + id);
        } else {
            userService.deleteById(id);
            return "User was deleted. ID" + id;
        }

    }


    @GetMapping("/user")
    public User showUserForUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/users/roles")
    public List<Role> getAllRoles() {
        return userService.listOfRoles();
    }
}
