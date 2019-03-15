package com.example.shardingjdbc.service;

import com.example.shardingjdbc.model.Student;

/**
 * Created by yangxin on 2019/3/15.
 */
public interface StudentService {
    Integer addStudent(Student student);
    Student getStudentByGid(long gid);
}
