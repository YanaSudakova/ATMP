package com.epam.tat.module4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for pow method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorPowTest {

    @ParameterizedTest(name = "Test power of {0} raised to {1}")
    @CsvSource({
            "2.0, 3.0, 8.0",
            "0.0, 5.0, 0.0",
            "-2.0, 2.0, 4.0"
    })
    @DisplayName("Test power of different numbers")
    public void testPowNumbers(double base, double exponent, double expected, Calculator calculator) {
        double result = calculator.pow(base, exponent);
        assertEquals(expected, result, 0.0001);
    }
}

