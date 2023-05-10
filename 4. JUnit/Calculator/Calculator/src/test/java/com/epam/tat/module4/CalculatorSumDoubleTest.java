package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.Assert.assertEquals;

@DisplayName("Tests for sum double of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSumDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test sum of positive doubles")
    public void testSumPositiveDoubles() {
        double result = calculator.sum(2.5, 3.7);
        assertEquals(6.2, result, 0.0001);
    }

    @Test
    @DisplayName("Test sum of negative doubles")
    public void testSumNegativeDoubles() {
        double result = calculator.sum(-2.5, -3.7);
        assertEquals(-6.2, result, 0.0001);
    }

    @Test
    @DisplayName("Test sum of zero and positive double")
    public void testSumZeroAndPositiveDouble() {
        double result = calculator.sum(0.0, 5.8);
        assertEquals(5.8, result, 0.0001);
    }

    @Test
    @DisplayName("Test sum of zero and negative double")
    public void testSumZeroAndNegativeDouble() {
        double result = calculator.sum(0.0, -5.8);
        assertEquals(-5.8, result, 0.0001);
    }

    @Test
    @DisplayName("Test sum of two zeros (double)")
    public void testSumTwoZerosDouble() {
        double result = calculator.sum(0.0, 0.0);
        assertEquals(0.0, result, 0.0001);
    }


}