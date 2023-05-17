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
@DisplayName("Tests for sub double method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSubDoubleTest {

    @ParameterizedTest(name = "Test subtraction of {0} and {1}")
    @CsvSource({
            "5.5, 2.2, 3.3",
            "-5.5, -2.2, -3.3",
            "0.0, 5.8, -5.8"
    })
    @DisplayName("Test subtraction with different doubles")
    public void testSubDoubleValues(double minuend, double subtrahend, double expected, Calculator calculator) {
        double result = calculator.sub(minuend, subtrahend);
        assertEquals(expected, result, 0.0001);
    }

}

