package com.example.shardingjdbc.controller;

import com.example.shardingjdbc.model.Student;
import com.example.shardingjdbc.service.StudentService;
import com.github.pagehelper.Page;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangxin on 2019/3/15.
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/add")
    public Object add(){
        for(int i=11;i<21;i++){
            Student student = new Student();
            student.setName("stu"+i);
            student.setAge(12+i);
            student.setClassNo("000"+i);
            student.setSex(0);
            student.setCreateTime(new Date());
            student.setGid((long)i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            studentService.addStudent(student);
        }
        return "success";
    }

    @RequestMapping("/gid/{gid}")
    public Object getStudentByGid(@PathVariable Integer gid){
        if(gid==null){
            return "gid 不能为null";
        }
        Student student = studentService.getStudentByGid(gid);
        if(student!=null)
            return new Gson().toJson(student);
        else
            return "no record";
    }

    @RequestMapping("/list/{page}")
    public Object getList(@PathVariable Integer page,@RequestBody Student student){
        if(page==null){
            page=0;
        }
        Map result = new HashMap();
        try {
            Page<Student> studentsPage = studentService.getList(page,student);
            result.put("status","0000");
            result.put("total", studentsPage.getTotal());
            result.put("rows", studentsPage.getResult());
            return new Gson().toJson(result);
        }catch (Exception e){
            e.printStackTrace();
            result.put("status","1000");
            result.put("message",e.getMessage());
        }
        return result;

    }

}
