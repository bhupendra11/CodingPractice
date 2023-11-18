package com.prep2023.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class _6_GCD_HCFTest {

    @Test
    public void testGCD_PositiveNumbers() {
        _6_GCD_or_HCF gcdHcf = new _6_GCD_or_HCF();
        int result = gcdHcf.gcd(12, 18);
        assertEquals(6, result);
    }

    @Test
    public void testGCD_OneZeroInput() {
        _6_GCD_or_HCF gcdHcf = new _6_GCD_or_HCF();
        int result1 = gcdHcf.gcd(0, 7);
        int result2 = gcdHcf.gcd(15, 0);
        assertEquals(7, result1);
        assertEquals(15, result2);
    }

    @Test
    public void testGCD_BothZeroInput() {
        _6_GCD_or_HCF gcdHcf = new _6_GCD_or_HCF();
        int result = gcdHcf.gcd(0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testGCD_PrimeNumbers() {
        _6_GCD_or_HCF gcdHcf = new _6_GCD_or_HCF();
        int result = gcdHcf.gcd(13, 17);
        assertEquals(1, result);
    }

    @Test
    public void testGCD_EqualNumbers() {
        _6_GCD_or_HCF gcdHcf = new _6_GCD_or_HCF();
        int result = gcdHcf.gcd(25, 25);
        assertEquals(25, result);
    }
}
