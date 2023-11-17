package com.prep2023.math;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _3_Calculate_Power_X_Y_Test {

    @Test
    public void testPowerWithPositiveBaseAndExponent() {
        assertEquals(1024, _3_Calculate_Power_X_Y.power(2, 10));
    }

    @Test
    public void testPowerWithDifferentBaseAndExponent() {
        assertEquals(59049, _3_Calculate_Power_X_Y.power(3, 10));
    }

    @Test
    public void testPowerWithSameBaseAndExponent() {
        assertEquals(3125, _3_Calculate_Power_X_Y.power(5, 5));
    }

    @Test
    public void testPowerWithBaseOne() {
        assertEquals(1, _3_Calculate_Power_X_Y.power(1, 100)); // any non-negative exponent with base 1 is 1
    }

    @Test
    public void testPowerWithExponentZero() {
        assertEquals(1, _3_Calculate_Power_X_Y.power(2, 0)); // any base with exponent 0 is 1
    }

    @Test
    public void testPowerWithNegativeExponent() {
        assertEquals(0, _3_Calculate_Power_X_Y.power(2, -4)); // 2^(-4) is 1/2^4 = 1/16 = 0.0625, rounded to 0 as the function returns integers
    }

    @Test
    public void testPowerWithNegativeBaseAndEvenExponent() {
        assertEquals(16, _3_Calculate_Power_X_Y.power(-2, 4)); // (-2)^4 is 2^4 = 16
    }

    @Test
    public void testPowerWithNegativeBaseAndOddExponent() {
        assertEquals(-8, _3_Calculate_Power_X_Y.power(-2, 3)); // (-2)^3 is -2^3 = -8
    }
}
