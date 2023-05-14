package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tests for isPositive method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorIsPositiveTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test isPositive with positive value")
    public void testIsPositiveWithPositiveValue() {
        long value = 10L;
        assertTrue(calculator.isPositive(value));
    }

    @Test
    @DisplayName("Test isPositive with zero value")
    public void testIsPositiveWithZeroValue() {
        long value = 0L;
        assertFalse(calculator.isPositive(value));
    }

    @Test
    @DisplayName("Test isPositive with negative value")
    public void testIsPositiveWithNegativeValue() {
        long value = -10L;
        assertFalse(calculator.isPositive(value));
    }
}

