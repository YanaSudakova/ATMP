package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tests for isNegative method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorIsNegativeTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test isNegative with positive value")
    public void testIsNegativeWithPositiveValue() {
        long value = 10L;
        assertFalse(calculator.isNegative(value));
    }

    @Test
    @DisplayName("Test isNegative with zero value")
    public void testIsNegativeWithZeroValue() {
        long value = 0L;
        assertFalse(calculator.isNegative(value));
    }

    @Test
    @DisplayName("Test isNegative with negative value")
    public void testIsNegativeWithNegativeValue() {
        long value = -10L;
        assertTrue(calculator.isNegative(value));
    }
}

