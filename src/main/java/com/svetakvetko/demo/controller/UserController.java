package com.svetakvetko.demo.controller;

import com.svetakvetko.demo.domain.User;
import com.svetakvetko.demo.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class UserController {

    @Autowired
    private UserServiceImpl service;


    @GetMapping("/users")
    Collection<User> findAll() {
        return service.findAll();
    }

    @PostMapping("/users")
    User create(@RequestBody User user) {
        return service.create(user);
    }


    @GetMapping("/users/{id}")
    User findById(@PathVariable Long id) {
        return service.findById(id);

    }

    @GetMapping("/users/{userLogin}")
    User findByLogin(@PathVariable String userLogin) {
        return service.findByLogin(userLogin);

    }

    @PutMapping("/users/{id}")
    User update(@RequestBody User user, @PathVariable Long id) {
        User temp = service.findById(id);
        return service.update(user);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }


}
