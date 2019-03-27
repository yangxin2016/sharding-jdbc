package com.example.shardingjdbc.service.serviceImpl;

import com.example.shardingjdbc.dao.StudentDao;
import com.example.shardingjdbc.mapper.StudentMapper;
import com.example.shardingjdbc.model.Student;
import com.example.shardingjdbc.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangxin on 2019/3/15.
 */
@Service
public class StudentServicempl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    private final int pageSize=5;

    @Override
    public Integer addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public Student getStudentByGid(long gid) {
        return studentDao.getStudentByGid(gid);
    }

    @Override
    public Page<Student> getList(Integer pageNum,Student student) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        studentDao.getList(student);
        return page;
    }
}
