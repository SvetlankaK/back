package com.svetakvetko.service;

import com.svetakvetko.domain.Role;
import com.svetakvetko.domain.User;
import com.svetakvetko.mapper.RoleMapper;
import com.svetakvetko.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public void create(User user) {
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
        user.setRole(roleService.getRolesById(userId));
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
    public void update(User user) {
        userMapper.update(user);
        Map<String, Object> userRole = new HashMap();
        roleMapper.deleteRolesById(user.getUserId());
        userRole.put("userId", user.getUserId());
        for (int i = 0; i < user.getRole().size(); i++) {
            userRole.put("roleId", user.getRole().get(i).getId());
            roleMapper.addRole(userRole);
        }
    }

    @Override
    public User findByLogin(String userLogin) {
        User user = userMapper.findByLogin(userLogin);
        user.setRole(roleService.getRolesById(user.getUserId()));
        return user;
    }
}