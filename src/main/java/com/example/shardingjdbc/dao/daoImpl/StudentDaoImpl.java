package com.example.shardingjdbc.dao.daoImpl;

import com.example.shardingjdbc.dao.StudentDao;
import com.example.shardingjdbc.mapper.StudentMapper;
import com.example.shardingjdbc.model.Student;
import com.example.shardingjdbc.model.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by yangxin on 2019/3/15.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Integer addStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Student getStudentByGid(long gid) {
        StudentExample example = new StudentExample();
        example.createCriteria().andGidEqualTo(gid);
        return studentMapper.selectByExample(example).get(0);
    }
}
