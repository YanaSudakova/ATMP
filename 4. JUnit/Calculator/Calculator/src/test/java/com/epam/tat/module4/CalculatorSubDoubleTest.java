package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for sub double method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSubDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test subtraction of positive doubles")
    public void testSubPositiveDoubles() {
        double result = calculator.sub(5.5, 2.2);
        assertEquals(3.3, result, 0.0001);
    }

    @Test
    @DisplayName("Test subtraction of negative doubles")
    public void testSubNegativeDoubles() {
        double result = calculator.sub(-5.5, -2.2);
        assertEquals(-3.3, result, 0.0001);
    }

    @Test
    @DisplayName("Test subtraction of zero and positive double")
    public void testSubZeroAndPositiveDouble() {
        double result = calculator.sub(0.0, 5.8);
        assertEquals(-5.8, result, 0.0001);
    }

}

