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
@DisplayName("Tests for isNegative method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorIsNegativeTest {

    @ParameterizedTest(name = "Test isNegative with {0}")
    @CsvSource({
            "10, false",
            "0, false",
            "-10, true"
    })
    @DisplayName("Test isNegative with different values")
    public void testIsNegative(long value, boolean expected, Calculator calculator) {
        boolean result = calculator.isNegative(value);
        assertEquals(expected, result);
    }
}

