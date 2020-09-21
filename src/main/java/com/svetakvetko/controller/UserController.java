package com.svetakvetko.controller;

import com.svetakvetko.domain.User;
import com.svetakvetko.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/users")
    Collection<User> findAll() {
        return service.findAll();
    }

    @PostMapping("/users")
    void create(@RequestBody User user) {
        service.create(user);
    }

    @GetMapping("/users/{userId}")
    User findById(@PathVariable Long userId) {
        return service.findById(userId);
    }

    @GetMapping()
    User findByLogin(@RequestParam(value = "userLogin") String userLogin) {
        return service.findByLogin(userLogin);
    }

    @PutMapping("/users/{userId}")
    void update(@RequestBody User user, @PathVariable Long userId) {
        service.update(user);
    }

    @DeleteMapping("/users/{userId}")
    void delete(@PathVariable Long userId) {
        service.delete(userId);
    }


}
