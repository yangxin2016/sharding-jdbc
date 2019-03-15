package com.example.shardingjdbc.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by yangxin on 2019/3/14.
 */
@RestController
@RequestMapping("hello")
public class Test {

    @PostConstruct
    public void test(){
        System.out.println("========server start");
    }

    @RequestMapping("/hello")
    public Object hello(@RequestBody User user){
        return "hello "+user.getName();
    }


}

class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
