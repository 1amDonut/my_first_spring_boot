package com.example.demo.service;

import com.example.demo.Student;

public interface StudentService {
    Integer insert(Student student);

    Student getById(Integer studentId);

    void update(Student student);

    void deleteById(Integer studentId);
}
