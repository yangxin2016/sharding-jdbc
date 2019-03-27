package com.example.shardingjdbc.controller;

import com.example.shardingjdbc.model.User;
import com.example.shardingjdbc.service.UserService;
import com.github.pagehelper.Page;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangxin on 2019/3/15.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public Object add(){
        for(int i=1;i<20;i++){
            User user = new User();
            user.setName("user-"+i);
            user.setClassNo(i);
            user.setCreateTime(new Date());
            user.setGid(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            userService.addUser(user);
        }
        return "success";
    }

    @RequestMapping("/gid/{gid}")
    public Object getUserByGid(@PathVariable Integer gid){
        if(gid==null){
            return "gid 不能为null";
        }
        User user = userService.getUserByGid(gid);
        if(user!=null)
            return new Gson().toJson(user);
        else
            return "no record";
    }

    @RequestMapping("/list/{page}")
    public Object getList(@PathVariable Integer page,@RequestBody User user){
        if(page==null){
            page=0;
        }
        Map result = new HashMap();
        try {
            Page<User> usersPage = userService.getList(page,user);
            result.put("status","0000");
            result.put("total", usersPage.getTotal());
            result.put("rows", usersPage.getResult());
            return new Gson().toJson(result);
        }catch (Exception e){
            e.printStackTrace();
            result.put("status","1000");
            result.put("message",e.getMessage());
        }
        return result;

    }

}
