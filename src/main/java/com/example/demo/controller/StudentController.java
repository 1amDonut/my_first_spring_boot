package com.example.demo.controller;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.Student;
import com.example.demo.StudentRowMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public String insert(@RequestBody Student student){

        studentRepository.save(student);

        return "執行資料庫的 Create 操作";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){

        Student s = studentRepository.findById(studentId).orElse(null);

        if (s != null){
            s.setName(student.getName());
            studentRepository.save(s);

            return "執行資料庫的Update操作";
        }else{
            return "Update 失敗，數據不存在";
        }

    }

    @DeleteMapping("/students/{studentId")
    public String delete(@PathVariable Integer studentId){

        studentRepository.deleteById(studentId);

        return "執行資料庫的Delete操作";
    }

    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer studentId){

//      Optional 用法 orElse 如果資料庫找不到這筆資訊，student的值就會是null
        Student student = studentRepository.findById(studentId).orElse(null);

        return student;
    }
}
