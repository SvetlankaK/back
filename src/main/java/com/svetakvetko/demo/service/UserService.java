package com.svetakvetko.demo.service;

import com.svetakvetko.demo.domain.User;

import java.util.List;

public interface UserService {

    void create(User user);

    void delete(Long userId);

    User findById(Long userId);

    List<User> findAll();

    User update(User user, long userId);

    User findByLogin(String userLogin);


}
