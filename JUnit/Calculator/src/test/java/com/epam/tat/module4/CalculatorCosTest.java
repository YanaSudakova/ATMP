package com.epam.tat.module4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CalculatorParameterResolver.class)
@DisplayName("Tests for cos method of Calculator.jar")
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorCosTest {

    @ParameterizedTest(name = "Test cosine of angle: {0}")
    @CsvSource({
            "0.5235987755982988, 0.8660254",
            "1.0471975511965979, 0.5"
    })
    @DisplayName("Test cosine of angle")
    public void testCosAngle(double angle, double expectedCosValue, Calculator calculator) {
        double result = calculator.cos(angle);
        assertEquals(expectedCosValue, result, 0.0001);
    }
}