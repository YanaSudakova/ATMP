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
@DisplayName("Tests for sin method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSinTest {

    @ParameterizedTest(name = "Test sine of angle: {0}")
    @CsvSource({
            "0.5236, 0.5",
            "0.7854, 0.7071",
            "1.0472, 0.866"
    })
    @DisplayName("Test sine of different angles")
    public void testSinAngle(double angle, double expected, Calculator calculator) {
        double result = calculator.sin(angle);
        assertEquals(expected, result, 0.0001);
    }
}

