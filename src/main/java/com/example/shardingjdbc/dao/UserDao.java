package com.example.shardingjdbc.dao;

import com.example.shardingjdbc.model.User;

import java.util.List;

/**
 * Created by yangxin on 2019/3/15.
 */
public interface UserDao {
    Integer addUser(User student);
    User getUserByGid(int gid);
    List<User> getList(User user);
}
