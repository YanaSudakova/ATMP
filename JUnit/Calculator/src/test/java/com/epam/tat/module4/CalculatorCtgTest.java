package com.epam.tat.module4;

import helpers.CalculatorParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for ctg method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorCtgTest {

    @ParameterizedTest(name = "Test cotangent of angle: {0}")
    @CsvSource({
            "30, 1.7320508",
            "45, 1.0",
            "90, 0.0"
    })
    @DisplayName("Test cotangent of angle")
    public void testCtgAngle(double angle, double expected, Calculator calculator) {
        double result = calculator.ctg(Math.toRadians(angle));
        assertEquals(expected, result, 0.0001);
    }
}
