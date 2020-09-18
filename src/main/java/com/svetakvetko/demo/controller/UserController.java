package com.svetakvetko.demo.controller;

import com.svetakvetko.demo.domain.Role;
import com.svetakvetko.demo.domain.User;
import com.svetakvetko.demo.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;


@RestController
public class UserController {

    @Autowired
    private UserServiceImpl service;


    @GetMapping("/Users")
    Collection<User> findAll() {
        return Collections.singletonList(new User("Sveta", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.200"));
    }

    @PostMapping("/Users")
    User create(@RequestBody User user) {
        return service.create(user);
    }


    @GetMapping("/Users/{id}")
    User findById(@PathVariable Long id) {
        return service.findById(id);

    }

    @GetMapping("/Users/{userLogin}")
    User findByLogin(@PathVariable String userLogin) {
        return service.findByLogin(userLogin);

    }

    @PutMapping("/Users/{id}")
    User update(@RequestBody User user, @PathVariable Long id) {
        return service.findById(id);

    }

    @DeleteMapping("/Users/{id}")
    void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }


}
