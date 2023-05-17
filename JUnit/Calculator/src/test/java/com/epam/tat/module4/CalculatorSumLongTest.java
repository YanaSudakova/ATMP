package com.epam.tat.module4;

import helpers.CalculatorParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for sum long of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSumLongTest {
    @ParameterizedTest(name = "Test sum of {0} and {1}")
    @CsvSource({
            "2, 3, 5",
            "-2, -3, -5",
            "0, 5, 5",
            "0, -5, -5",
            "0, 0, 0"
    })
    @DisplayName("Test sum with different longs")
    public void testSumLongValues(long addendA, long addendB, long expected, Calculator calculator) {
        long result = calculator.sum(addendA, addendB);
        assertEquals(expected, result);
    }
}
