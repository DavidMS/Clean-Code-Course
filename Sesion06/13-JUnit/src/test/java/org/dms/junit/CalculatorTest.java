package org.dms.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class CalculatorTest {

    private Calculator calculator;

    private boolean skipZero = false;

    public static int[][] data() {
        return new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
    }

    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5), "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    public void testMultiplyWithZero() {

        Assumptions.assumeFalse(skipZero);

        assertEquals(0, calculator.multiply(0, 5), "Multiple with zero should be zero");
        assertEquals(0, calculator.multiply(5, 0), "Multiple with zero should be zero");
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMinutes(1), () -> calculator.multiply(2, 2));
    }

    @Test
    void timeoutNotExceededWithResult() {
        int result = assertTimeout(Duration.ofSeconds(1), () -> calculator.multiply(2, 10));

        assertEquals(20, result);
    }

    @Test
    void timeoutNotExceededWithResultAndCancel() {
        int result = assertTimeoutPreemptively(Duration.ofSeconds(1), () -> calculator.multiply(2, 10));

        assertEquals(20, result);
    }

    @TestFactory
    public Stream<DynamicTest> testDifferentMultiplyOperations() {
        int[][] data = new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
        return Arrays.stream(data).map(entry -> {
            int m1 = entry[0];
            int m2 = entry[1];
            int expected = entry[2];
            return dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
                assertEquals(expected, calculator.multiply(m1, m2));
            });
        });
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void testWithStringParameter(int[] data) {
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, calculator.multiply(m1, m2));
    }


}
