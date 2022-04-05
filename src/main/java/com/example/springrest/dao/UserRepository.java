package com.example.springrest.dao;


import com.example.springrest.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);

    User findByEmail(String email);

}