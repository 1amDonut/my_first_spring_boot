package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;

    @Override
    public Integer insert(Student student) {
        return studentDao.Insert(student);
    }

    @Override
    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteById(Integer studentId) {
        studentDao.deleteById(studentId);
    }
}
