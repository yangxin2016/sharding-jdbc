package com.example.shardingjdbc.controller;

import com.example.shardingjdbc.model.Student;
import com.example.shardingjdbc.service.StudentService;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
        for(int i=1;i<11;i++){
            Student student = new Student();
            student.setName("stu"+i);
            student.setAge(12+i);
            student.setClassNo("000"+i);
            student.setSex(1);
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

}
