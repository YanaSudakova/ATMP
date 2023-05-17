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
@DisplayName("Tests for sum double of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSumDoubleTest {

    @ParameterizedTest(name = "Test sum of {0} and {1}")
    @CsvSource({
            "2.5, 3.7, 6.2",
            "-2.5, -3.7, -6.2",
            "0.0, 5.8, 5.8",
            "0.0, -5.8, -5.8",
            "0.0, 0.0, 0.0"
    })
    @DisplayName("Test sum with different doubles")
    public void testSumDoubleValues(double addendA, double addendB, double expected, Calculator calculator) {
        double result = calculator.sum(addendA, addendB);
        assertEquals(expected, result, 0.0001);
    }
}