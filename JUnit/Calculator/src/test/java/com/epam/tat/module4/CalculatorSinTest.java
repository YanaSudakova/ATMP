package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for sin method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSinTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test sine of angle")
    public void testSinAngle() {
        double angle = Math.PI / 6.0; // 30 degrees
        double expectedSinValue = Math.sin(angle);

        double result = calculator.sin(angle);
        assertEquals(expectedSinValue, result, 0.0001);
    }
}

