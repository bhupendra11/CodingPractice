package com.bhupendra.prep2023.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class _5_Calculate_N_choose_R_Test {

    @Test
    public void testNChooseRWithSmallNumbers() {
        _5_Calculate_N_choose_R calculator = new _5_Calculate_N_choose_R();
        assertEquals(1, calculator.ncr(5, 0));
        assertEquals(5, calculator.ncr(5, 1));
        assertEquals(10, calculator.ncr(5, 2));
        assertEquals(10, calculator.ncr(5, 3));
        assertEquals(5, calculator.ncr(5, 4));
        assertEquals(1, calculator.ncr(5, 5));
    }

    @Test
    public void testNChooseRWithLargeNumbers() {
        _5_Calculate_N_choose_R calculator = new _5_Calculate_N_choose_R();
        assertEquals(462, calculator.ncr(11, 5));
        assertEquals(924, calculator.ncr(12, 6));
        assertEquals(105, calculator.ncr(15, 2));
        assertEquals(1287, calculator.ncr(13, 5));
        assertEquals(6435, calculator.ncr(15, 7));
    }

    @Test
    public void testNChooseRWithEqualNumbers() {
        _5_Calculate_N_choose_R calculator = new _5_Calculate_N_choose_R();
        assertEquals(1, calculator.ncr(8, 8));
        assertEquals(1, calculator.ncr(12, 12));
        assertEquals(1, calculator.ncr(3, 3));
    }

    @Test
    public void testNChooseRWithZeroN() {
        _5_Calculate_N_choose_R calculator = new _5_Calculate_N_choose_R();
        assertEquals(0, calculator.ncr(0, 5));
    }

    @Test
    public void testNChooseRWithZeroR() {
        _5_Calculate_N_choose_R calculator = new _5_Calculate_N_choose_R();
        assertEquals(1, calculator.ncr(5, 0));
    }
}
