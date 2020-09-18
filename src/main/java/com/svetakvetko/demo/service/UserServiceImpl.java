package com.svetakvetko.demo.service;

import com.svetakvetko.demo.domain.Role;
import com.svetakvetko.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> fakeUsers = new ArrayList<>();

    static {
        Collections.addAll(fakeUsers,
                new User("Sveta", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 1),
                new User("Sveta", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 3),
                new User("Sveta", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 3),
                new User("Sveta", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 4));
    }

    @Override
    public User create(User user) {
        return new User("Sveta", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 1);
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
    public List<User> findAll() {
        return new ArrayList<>(fakeUsers);
    }

    @Override
    public User update(User user) {

        return user;
    }

    @Override
    public User findByLogin(String userLogin) {
        return null;
    }
}
