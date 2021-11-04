package com.example.demo.controller;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.Student;
import com.example.demo.StudentRowMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> insert(@RequestBody Student student){

        Integer studentId = studentService.insert(student);

        Student newstudent = studentService.getById(studentId);

        return ResponseEntity.status(HttpStatus.CREATED).body(newstudent);
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<?> update(@PathVariable Integer studentId,
                                         @RequestBody Student student){

        student.setId(studentId);
        studentService.update(student);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/students/{studentId")
    public ResponseEntity<?> delete(@PathVariable Integer studentId){

        studentService.deleteById(studentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> read(@PathVariable Integer studentId){

        Student student = studentService.getById(studentId);

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}
