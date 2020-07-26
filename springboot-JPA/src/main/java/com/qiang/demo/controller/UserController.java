package com.qiang.demo.controller;

import com.qiang.demo.Repository.UserRepository;
import com.qiang.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).get();
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
}
