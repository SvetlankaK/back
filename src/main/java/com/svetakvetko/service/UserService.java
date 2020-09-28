package com.svetakvetko.service;

import com.svetakvetko.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void create(User user);

    void delete(Long userId);

    User findById(Long userId);

    List<User> findAll();

    void update(User user, long userId);

    User findByLogin(String userLogin);

    void register(User user);

    boolean uniqueLogin(String userLogin);

}
