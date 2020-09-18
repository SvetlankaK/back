package com.svetakvetko.demo.service;

import com.svetakvetko.demo.domain.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(Long userId);

    User findById(Long UserId);

    boolean isExist(String userLogin);
    List<User> findAll();

    User update(User user);

    User findByLogin(String userLogin);


}
