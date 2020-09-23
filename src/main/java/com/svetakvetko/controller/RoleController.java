package com.svetakvetko.controller;

import com.svetakvetko.domain.Role;
import com.svetakvetko.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping()
    List<Role> findAll() {
        return service.getAllPossibleRoles();
    }

}
