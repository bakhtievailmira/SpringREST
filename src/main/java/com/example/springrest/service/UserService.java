package com.example.springrest.service;


import com.example.springrest.model.Role;
import com.example.springrest.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save(User user);

    List<User> findAll();

    void deleteById(long id);

    User findById(long id);

    UserDetails loadUserByUsername(String userName);

    List<Role> listOfRoles();
}
