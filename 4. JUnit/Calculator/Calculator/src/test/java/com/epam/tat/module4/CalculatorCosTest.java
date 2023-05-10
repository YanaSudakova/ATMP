package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for cos method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorCosTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test cosine of angle")
    public void testCosAngle() {
        double angle = Math.PI / 3.0; // 60 degrees
        double expectedCosValue = Math.cos(angle);

        double result = calculator.cos(angle);
        assertEquals(expectedCosValue, result, 0.0001);
    }
}

