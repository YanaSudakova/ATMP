package com.epam.tat.module4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for sqrt method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSqrtTest {

    @ParameterizedTest(name = "Test square root of {0}")
    @CsvSource({
            "9.0, 3.0",
            "0.0, 0.0",
            "4.0, 2.0"
    })
    @DisplayName("Test square root with different numbers")
    public void testSqrtNumber(double input, double expected, Calculator calculator) {
        double result = calculator.sqrt(input);
        assertEquals(expected, result, 0.0001);
    }
}

