package com.epam.tat.module4;

import helpers.CalculatorParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for tg method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorTgTest {

    @ParameterizedTest(name = "Test tangent of angle: {0}")
    @CsvSource({
            "45.0, 1.0"
    })
    public void testTgAngle(double angle, double expected, Calculator calculator) {
        double sinValue = Math.sin(Math.toRadians(angle));

        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.sin(angle)).thenReturn(sinValue);

        double result = calculator.tg(angle);
        assertEquals(expected, result, 0.0001);
    }
}
