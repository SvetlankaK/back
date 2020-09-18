package com.svetakvetko.demo.service;

import com.svetakvetko.demo.domain.Role;
import com.svetakvetko.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public User create(User user) {
        return new User("Sveta", "gfhjkm",  Collections.singletonList(new Role(1, "admin")) , "email@com", "Sveta", "Kvetko", 3333, "06.04.200");
    }

    @Override
    public void delete(Long userId) {
    }

    @Override
    public User findById(Long UserId) {
        return null;
    }

    @Override
    public boolean isExist(String userLogin) {
        return false;
    }

    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findByLogin(String userLogin) {
        return null;
    }
}
