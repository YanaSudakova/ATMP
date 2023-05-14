package com.epam.tat.module4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for sub long method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSubLongTest {

    @ParameterizedTest(name = "Test subtraction of {0} and {1}")
    @CsvSource({
            "5, 3, 2",
            "-5, -3, -2",
            "0, 5, -5"
    })
    @DisplayName("Test subtraction with different longs")
    public void testSubLongValues(long a, long b, long expected, Calculator calculator) {
        long result = calculator.sub(a, b);
        assertEquals(expected, result);
    }
}

