package com.example.shardingjdbc.dao;

import com.example.shardingjdbc.model.Student;

/**
 * Created by yangxin on 2019/3/15.
 */
public interface StudentDao {
    Integer addStudent(Student student);
    Student getStudentByGid(long gid);
}
