package com.example.demo;

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
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    @PostMapping("/students") 推薦 方法一
//    @RequestMapping(value = "/students", method = RequestMethod.POST)
//    public String Create(@RequestBody @Valid Student student){
//        return "執行資料庫的Create操作";
//    }

    @GetMapping("/students/{studentId}")
    public String Read(@PathVariable @NotNull Integer studentId){
        return "執行資料庫Read操作";
    }

    @PutMapping("/students/{studentId}")
    public String Update(@PathVariable @NotNull Integer studentId,
                         @RequestBody Student student){
        return "更新資料庫update操作";
    }

    @DeleteMapping("/students/{studentId}")
    public String Delete(@PathVariable Integer studentId){
        return "執行資料Delte操作";
    }

//    批量插入
    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentList){
        String sql = "INSERT INTO student (name) VALUE (:studentName)";

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];

        for (int i=0; i<studentList.size(); i++){
            Student student = studentList.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName", student.getName());
        }
        namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);
        return "執行一批 INSERT sql";
    }

    @PostMapping("/students")
    public String insert(@RequestBody Student student){
        String sql = "INSERT INTO student( name) VALUES (:studentName);";

        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();

        return "執行 INSERT SQL";
    }

    @GetMapping("/students")
    public List<Student> select(){
        String sql = "SELECT id, name FROM student";

        Map<String, Object> map = new HashMap<>();

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        return list;
    }
}
