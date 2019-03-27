package com.example.shardingjdbc.service;

import com.example.shardingjdbc.model.Student;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by yangxin on 2019/3/15.
 */
public interface StudentService {
    Integer addStudent(Student student);
    Student getStudentByGid(long gid);
    Page<Student> getList(Integer pageNum, Student student);
}
