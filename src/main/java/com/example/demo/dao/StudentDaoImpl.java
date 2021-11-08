package com.example.demo.dao;

import com.example.demo.Student;
import com.example.demo.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student getById(Integer id) {
        String sql = "SELECT id, name FROM student WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        if(list.size() > 0) return list.get(0);
        else return null;

    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE student SET name = :name WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", student.getId());
        map.put("name", student.getName());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM student WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id",id);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public Integer Insert(Student student) {
        String sql = "INSERT INTO student(name) VALUES (:name)";

        Map<String, Object> map = new HashMap<>();
        map.put("name",student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();

        return id;
    }
}
