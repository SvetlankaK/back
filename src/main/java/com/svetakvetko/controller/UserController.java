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

    @GetMapping("/users/{id}")
    User findById(@PathVariable Long id) {
        return service.findById(id);

    }

    @GetMapping()
    User findByLogin(@RequestParam(value = "userLogin") String userLogin) {
        return service.findByLogin(userLogin);
    }

    @PutMapping("/users/{id}")
    void update(@RequestBody User user, @PathVariable Long id) {
        service.update(user);
    }

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
