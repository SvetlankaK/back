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
    User update(@RequestBody User user, @PathVariable Long id) {
        return service.update(user, id);
    }

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
