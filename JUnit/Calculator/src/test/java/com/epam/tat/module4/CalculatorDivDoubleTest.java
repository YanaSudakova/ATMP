package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Tests for div double method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorDivDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test division of positive doubles")
    public void testDivPositiveDoubles() {
        double result = calculator.div(6.0, 2.0);
        assertEquals(3.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test division by zero")
    public void testDivByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.div(10.0, 0.0));
    }

    @Test
    @DisplayName("Test division of negative doubles")
    public void testDivNegativeDoubles() {
        double result = calculator.div(-6.0, -2.0);
        assertEquals(3.0, result, 0.0001);
    }
}

