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
@DisplayName("Tests for div double method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorDivDoubleTest {

    @ParameterizedTest(name = "Test division of doubles: {0} / {1} = {2}")
    @CsvSource({
            "6.0, 2.0, 3.0",
            "10.0, 0.0, Infinity",
            "-6.0, -2.0, 3.0"
    })
    @DisplayName("Test division of different doubles")
    public void testDivDoubles(double dividend, double divisor, double expected, Calculator calculator) {
        double result = calculator.div(dividend, divisor);
        assertEquals(expected, result, 0.0001);
    }
}

