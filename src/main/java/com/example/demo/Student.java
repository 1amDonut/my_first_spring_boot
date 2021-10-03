package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Student {
    @NotNull
    Integer id;
    @NotBlank
    String name;
    Double store;
    boolean graduated;
    Integer age;
    List<String> courseList;
    Pet pet;
    List<Pet> petList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
