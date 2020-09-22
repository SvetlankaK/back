package com.svetakvetko.controller;

import com.svetakvetko.domain.User;
import com.svetakvetko.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping()
    Collection<User> findAll() {
        return service.findAll();
    }

    @PostMapping()
    void create(@RequestBody User user) {
        service.create(user);
    }

    @GetMapping("/{userId}")
    User findById(@PathVariable Long userId) {
        return service.findById(userId);
    }

    @GetMapping("/login/{userLogin}")
    User findByLogin(@PathVariable String userLogin) {
        return service.findByLogin(userLogin);
    }

    @PutMapping("/{userId}")
    void update(@RequestBody User user, @PathVariable Long userId) {
        service.update(user, userId);
    }

    @DeleteMapping("/{userId}")
    void delete(@PathVariable Long userId) {
        service.delete(userId);
    }


}
