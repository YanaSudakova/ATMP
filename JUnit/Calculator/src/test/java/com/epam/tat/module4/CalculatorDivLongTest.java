package com.epam.tat.module4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for div long method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorDivLongTest {

    @ParameterizedTest(name = "Test division of {0} by {1}")
    @CsvSource({
            "6, 3, 2",
            "10, 2, 5",
            "-6, -3, 2",
    })
    @DisplayName("Test division of different longs")
    public void testDivNumbers(long dividend, long divisor, long expected, Calculator calculator) {
        long result = calculator.div(dividend, divisor);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test division by zero")
    public void testDivByZero(Calculator calculator) {
        assertThrows(NumberFormatException.class, () -> calculator.div(10, 0));
    }
}
