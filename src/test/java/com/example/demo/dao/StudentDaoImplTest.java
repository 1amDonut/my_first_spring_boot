package com.example.demo.dao;

import com.example.demo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDaoImplTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    void getById() {
        Student student = studentDao.getById(1);
        assertNotNull(student);
        assertEquals("Amy", student.getName());

    }
}