package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.Assert.assertEquals;

@DisplayName("Tests for sum long of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSumLongTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test sum of positive numbers")
    public void testSumPositiveNumbers() {
        long result = calculator.sum(2, 3);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Test sum of negative numbers")
    public void testSumNegativeNumbers() {
        long result = calculator.sum(-2, -3);
        assertEquals(-5, result);
    }

    @Test
    @DisplayName("Test sum of zero and positive number")
    public void testSumZeroAndPositiveNumber() {
        long result = calculator.sum(0, 5);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Test sum of zero and negative number")
    public void testSumZeroAndNegativeNumber() {
        long result = calculator.sum(0, -5);
        assertEquals(-5, result);
    }

    @Test
    @DisplayName("Test sum of two zeros")
    public void testSumTwoZeros() {
        long result = calculator.sum(0, 0);
        assertEquals(0, result);
    }
}
