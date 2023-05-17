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
@DisplayName("Tests for isPositive method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorIsPositiveTest {

    @ParameterizedTest(name = "Test isPositive with {0}")
    @CsvSource({
            "10, true",
            "0, false",
            "-10, false"
    })
    @DisplayName("Test isPositive with different values")
    public void testIsPositive(long value, boolean expected, Calculator calculator) {
        boolean result = calculator.isPositive(value);
        assertEquals(expected, result);
    }
}

