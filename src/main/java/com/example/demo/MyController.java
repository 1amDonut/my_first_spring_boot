package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @RequestMapping("/product")
    public Store product(){
        Store store = new Store();
        List<Student> list = new ArrayList<>();

        Student student = new Student();
        student.setName("judy");
        list.add(student);
        store.setProductList(list);

        return store;
    }

    @RequestMapping("/user")
    public Student user(){
        Student student = new Student();
        student.setName("judy");
        return student;
    }

    //    請求參數方法二
    @RequestMapping("/test2")
    public String test2(@RequestBody Student student){ /* RequestBody 取得 body 參數*/
        System.out.println("student id " + student.id);
        System.out.println("student name " + student.name);
        return "hello test2";
    }


    //    請求參數方法三
    @RequestMapping("/test3")
    public String test3(@RequestHeader String info){
        System.out.println("info " + info);
        return "Hello test3";
    }

    //    請求參數方法四
    @RequestMapping("/test4/{id}/{name}")
    public ResponseEntity<String> test4(@PathVariable Integer id,
                                       @PathVariable String name){
        System.out.println("id  " + id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello world");

    }
}
