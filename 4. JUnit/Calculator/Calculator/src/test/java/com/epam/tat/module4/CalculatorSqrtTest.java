package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for sqrt method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSqrtTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test square root of positive number")
    public void testSqrtPositiveNumber() {
        double result = calculator.sqrt(9.0);
        assertEquals(3.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test square root of zero")
    public void testSqrtZero() {
        double result = calculator.sqrt(0.0);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test square root of negative number")
    public void testSqrtNegativeNumber() {
        double result = calculator.sqrt(-9.0);
        assertEquals(3.0, result, 0.0001);
    }
}

