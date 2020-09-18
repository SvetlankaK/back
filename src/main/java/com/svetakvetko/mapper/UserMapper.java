package com.svetakvetko.mapper;

import com.svetakvetko.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    List<User> findAll();

    User findById(Long userId);

    User findByLogin(String userLogin);

    void delete(Long userId);

    void update(User user);

    void create(User user);

    Long getIdByLogin(String userLogin);

}
