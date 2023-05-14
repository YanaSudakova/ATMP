package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for mult long method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultLongTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test multiplication of positive numbers")
    public void testMultPositiveNumbers() {
        long result = calculator.mult(2, 3);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Test multiplication of negative numbers")
    public void testMultNegativeNumbers() {
        long result = calculator.mult(-2, -3);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Test multiplication of zero and positive number")
    public void testMultZeroAndPositiveNumber() {
        long result = calculator.mult(0, 5);
        assertEquals(0, result);
    }
}

