package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for ctg method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorCtgTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test cotangent of angle")
    public void testCtgAngle() {
        double angle = 60.0;
        double expectedCtgValue = 1.0 / Math.tan(Math.toRadians(angle));

        double result = calculator.ctg(Math.toRadians(angle));
        assertEquals(expectedCtgValue, result, 0.0001);
    }
}
