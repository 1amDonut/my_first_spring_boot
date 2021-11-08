package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void insert() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"josh\",\n" +
                        "    \"scoure\": 97,\n" +
                        "    \"graduate\":true\n" +
                        "}");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201));
    }

    @Test
    void update() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/students/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"sisy\",\n" +
                        "    \"scoure\": 97,\n" +
                        "    \"graduate\":true\n" +
                        "}");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200));
    }

    @Test
    void delete() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/students/1");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200));
    }

    @Test
    void read() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/students/1");
//      寫法二：.get("/students/{studentId}", 3)

//        .andReturn 取得完整結果
        MvcResult mvcResult =  mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id",equalTo(1)))
                .andExpect(jsonPath("$.name", notNullValue()))
                .andReturn();
        String  body = mvcResult.getResponse().getContentAsString();
        System.out.print("返回的response body為：" + body);
    }
}