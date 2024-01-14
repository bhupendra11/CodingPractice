package com.bhupendra.prep2023.math.catalanNumbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class _2_NumberOfValidParenthesisTest {

    @Test
    public void testValidParenthesis_NonNegativeInput() {
        _2_NumberOfValidParenthesis parenthesisCounter = new _2_NumberOfValidParenthesis();
        int result = parenthesisCounter.validParenthesis(3);
        assertEquals(5, result);
    }

    @Test
    public void testValidParenthesis_ZeroInput() {
        _2_NumberOfValidParenthesis parenthesisCounter = new _2_NumberOfValidParenthesis();
        int result = parenthesisCounter.validParenthesis(0);
        assertEquals(1, result);
    }

    @Test
    public void testValidParenthesis_LargeInput() {
        _2_NumberOfValidParenthesis parenthesisCounter = new _2_NumberOfValidParenthesis();
        // Testing with a larger input value
        int result = parenthesisCounter.validParenthesis(10);
        assertEquals(16796, result);
    }

    @Test
    public void testValidParenthesis_EvenInput() {
        _2_NumberOfValidParenthesis parenthesisCounter = new _2_NumberOfValidParenthesis();
        int result = parenthesisCounter.validParenthesis(4);
        assertEquals(14, result);
    }

    @Test
    public void testValidParenthesis_OddInput() {
        _2_NumberOfValidParenthesis parenthesisCounter = new _2_NumberOfValidParenthesis();
        int result = parenthesisCounter.validParenthesis(5);
        assertEquals(42, result);
    }
}
