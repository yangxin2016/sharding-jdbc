package com.example.shardingjdbc.dao.daoImpl;

import com.example.shardingjdbc.dao.UserDao;
import com.example.shardingjdbc.mapper.UserMapper;
import com.example.shardingjdbc.model.User;
import com.example.shardingjdbc.model.UserExample;
import com.example.shardingjdbc.util.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yangxin on 2019/3/15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getUserByGid(int gid) {
        UserExample example = new UserExample();
        example.createCriteria().andGidEqualTo(gid);
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public List<User> getList(User user) {
        UserExample example = new UserExample();
        MapperHelper<UserExample.Criteria, User> mapperHelper = new MapperHelper();
        mapperHelper.exactQuery(example.createCriteria(), user);
        example.setOrderByClause("gid");
        return userMapper.selectByExample(example);
    }
}
