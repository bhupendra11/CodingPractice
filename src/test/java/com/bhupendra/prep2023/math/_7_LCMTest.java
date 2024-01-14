package com.bhupendra.prep2023.math;

import org.junit.Test;
import static org.junit.Assert.*;

public class _7_LCMTest {

    @Test
    public void testLCM_PositiveNumbers() {
        _7_LCM lcmCalculator = new _7_LCM();
        int result = lcmCalculator.lcm(12, 18);
        assertEquals(36, result);
    }

    @Test
    public void testLCM_OneZeroInput() {
        _7_LCM lcmCalculator = new _7_LCM();
        int result1 = lcmCalculator.lcm(0, 7);
        int result2 = lcmCalculator.lcm(15, 0);
        assertEquals(0, result1);
        assertEquals(0, result2);
    }

    @Test
    public void testLCM_BothZeroInput() {
        _7_LCM lcmCalculator = new _7_LCM();
        int result = lcmCalculator.lcm(0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testLCM_PrimeNumbers() {
        _7_LCM lcmCalculator = new _7_LCM();
        int result = lcmCalculator.lcm(13, 17);
        assertEquals(221, result);
    }

    @Test
    public void testLCM_EqualNumbers() {
        _7_LCM lcmCalculator = new _7_LCM();
        int result = lcmCalculator.lcm(25, 25);
        assertEquals(25, result);
    }
}
