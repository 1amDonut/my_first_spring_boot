package com.example.demo.dao;

import com.example.demo.Student;

public interface StudentDao {
    Student getById(Integer studentId);

    void update(Student student);

    void deleteById(Integer studentId);

    Integer Insert(Student student);
}
