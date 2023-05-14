package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for pow method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorPowTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test power of positive numbers")
    public void testPowPositiveNumbers() {
        double result = calculator.pow(2.0, 3.0);
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test power of zero")
    public void testPowZero() {
        double result = calculator.pow(0.0, 5.0);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test power of negative number")
    public void testPowNegativeNumber() {
        double result = calculator.pow(-2.0, 2.0);
        assertEquals(4.0, result, 0.0001);
    }
}

