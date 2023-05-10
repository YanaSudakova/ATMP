package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for sub long method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSubLongTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test subtraction of positive numbers")
    public void testSubPositiveNumbers() {
        long result = calculator.sub(5, 3);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Test subtraction of negative numbers")
    public void testSubNegativeNumbers() {
        long result = calculator.sub(-5, -3);
        assertEquals(-2, result);
    }

    @Test
    @DisplayName("Test subtraction of zero and positive number")
    public void testSubZeroAndPositiveNumber() {
        long result = calculator.sub(0, 5);
        assertEquals(-5, result);
    }
}

