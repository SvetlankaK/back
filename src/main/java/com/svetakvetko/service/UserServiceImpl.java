package com.svetakvetko.service;


import com.svetakvetko.domain.Role;
import com.svetakvetko.domain.User;
import com.svetakvetko.mapper.RoleMapper;
import com.svetakvetko.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.create(user);
        user.setUserId(userMapper.getIdByLogin(user.getUserLogin()));
        Map<String, Object> userRole = new HashMap();
        userRole.put("userId", user.getUserId());
        for (int i = 0; i < user.getRole().size(); i++) {
            userRole.put("roleId", user.getRole().get(i).getId());
            roleMapper.addRole(userRole);
        }
    }

    @Override
    public void delete(Long userId) {
        userMapper.delete(userId);
    }

    @Override
    public User findById(Long userId) {
        User user = userMapper.findById(userId);
        if (user != null) {
            user.setRole(roleService.getRolesById(userId));
        }
        return user;
    }


    @Override
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            user.setRole(roleService.getRolesById(user.getUserId()));
        }
        return users;
    }


    @Override
    public void update(User user, long userId) {
        user.setUserId(userId);
        userMapper.update(user);
        Map<String, Object> userRole = new HashMap();
        roleMapper.deleteRolesById(userId);
        userRole.put("userId", userId);
        for (int i = 0; i < user.getRole().size(); i++) {
            userRole.put("roleId", user.getRole().get(i).getId());
            roleMapper.addRole(userRole);
        }
    }

    @Override
    public User findByLogin(String userLogin) {
        User user = userMapper.findByLogin(userLogin);
        if (user != null) {
            user.setRole(roleService.getRolesById(user.getUserId()));
        }
        return user;
    }

    @Override
    public User loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        User user = findByLogin(userLogin);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public void register(User user) {
        user.setRole(Collections.singletonList(new Role(1, "user")));
        create(user);
    }

    @Override
    public boolean uniqueLogin(String userLogin) {
        return this.findByLogin(userLogin) == null;
    }
}


