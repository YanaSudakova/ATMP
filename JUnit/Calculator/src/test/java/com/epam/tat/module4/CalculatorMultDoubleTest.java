package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for mult double method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test multiplication of positive doubles")
    public void testMultPositiveDoubles() {
        double result = calculator.mult(2.5, 3.3);
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test multiplication of negative doubles")
    public void testMultNegativeDoubles() {
        double result = calculator.mult(-2.5, -3.3);
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test multiplication of zero and positive double")
    public void testMultZeroAndPositiveDouble() {
        double result = calculator.mult(0.0, 5.8);
        assertEquals(0.0, result, 0.0001);
    }

}

