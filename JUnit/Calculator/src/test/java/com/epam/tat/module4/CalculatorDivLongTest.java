package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Tests for div long method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorDivLongTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test division of positive numbers")
    public void testDivPositiveNumbers() {
        long result = calculator.div(6, 3);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Test division by zero")
    public void testDivByZero() {
        assertThrows(NumberFormatException.class, () -> calculator.div(10, 0));
    }

    @Test
    @DisplayName("Test division of negative numbers")
    public void testDivNegativeNumbers() {
        long result = calculator.div(-6, -3);
        assertEquals(2, result);
    }
}
