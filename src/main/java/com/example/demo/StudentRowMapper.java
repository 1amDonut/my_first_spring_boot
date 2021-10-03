package com.example.demo;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//        將資料庫查詢出來的數據換成Student
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));

        return student;
    }


}
