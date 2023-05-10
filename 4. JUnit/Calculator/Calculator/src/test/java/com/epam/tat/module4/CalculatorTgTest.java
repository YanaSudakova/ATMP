package com.epam.tat.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Tests for tg method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorTgTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test tangent of angle")
    public void testTgAngle() {
        double angle = 45.0;
        double sinValue = Math.sin(Math.toRadians(angle));
        double cosValue = Math.cos(Math.toRadians(angle));
        double expectedTgValue = sinValue / cosValue;

        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.sin(angle)).thenReturn(sinValue);
        when(mockCalculator.cos(angle)).thenReturn(cosValue);

        double result = calculator.tg(angle);
        assertEquals(expectedTgValue, result, 0.0001);
    }
}
