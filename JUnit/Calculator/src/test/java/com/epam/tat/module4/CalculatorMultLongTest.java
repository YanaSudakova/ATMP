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
@DisplayName("Tests for mult long method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultLongTest {

    @ParameterizedTest(name = "Test multiplication of {0} and {1}")
    @CsvSource({
            "2, 3, 6",
            "-2, -3, 6",
            "0, 5, 0"
    })
    @DisplayName("Test multiplication of different longs")
    public void testMultNumbers(long factorA, long factorB, long expected, Calculator calculator) {
        long result = calculator.mult(factorA, factorB);
        assertEquals(expected, result);
    }
}

