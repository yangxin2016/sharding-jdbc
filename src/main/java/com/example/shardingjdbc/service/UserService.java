package com.example.shardingjdbc.service;

import com.example.shardingjdbc.model.User;
import com.github.pagehelper.Page;

/**
 * Created by yangxin on 2019/3/15.
 */
public interface UserService {
    Integer addUser(User user);
    User getUserByGid(int gid);
    Page<User> getList(Integer pageNum, User user);
}
