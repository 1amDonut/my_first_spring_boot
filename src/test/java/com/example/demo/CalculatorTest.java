package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void add(){
        Calculator calculator = new Calculator();
        int reuslt = calculator.add(1,2);

        assertEquals(3,reuslt);
    }
}