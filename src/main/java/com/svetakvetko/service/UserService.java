package com.svetakvetko.service;

import com.svetakvetko.domain.User;

import java.util.List;

public interface UserService {

    void create(User user);

    void delete(Long userId);

    User findById(Long userId);

    List<User> findAll();

    void update(User user);

    User findByLogin(String userLogin);


}
