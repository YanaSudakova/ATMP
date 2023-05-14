package com.epam.tat.module4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for mult double method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorMultDoubleTest {

    @ParameterizedTest(name = "Test multiplication of {0} and {1}")
    @CsvSource({
            "2.5, 3.3, 8.0",
            "-2.5, -3.3, 8.0",
            "0.0, 5.8, 0.0"
    })
    @DisplayName("Test multiplication of doubles")
    public void testMultDoubles(double a, double b, double expected, Calculator calculator) {
        double result = calculator.mult(a, b);
        assertEquals(expected, result, 0.0001);
    }
}

