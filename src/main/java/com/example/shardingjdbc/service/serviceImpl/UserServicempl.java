package com.example.shardingjdbc.service.serviceImpl;

import com.example.shardingjdbc.dao.UserDao;
import com.example.shardingjdbc.model.User;
import com.example.shardingjdbc.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangxin on 2019/3/15.
 */
@Service
public class UserServicempl implements UserService {

    @Autowired
    private UserDao userDao;
    private final int pageSize=5;

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUserByGid(int gid) {
        return userDao.getUserByGid(gid);
    }

    @Override
    public Page<User> getList(Integer pageNum,User user) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        userDao.getList(user);
        return page;
    }
}
