package com.prep2023.math.catalanNumbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class _3_NumberOfPossibleBnaryTreesTest {

    @Test
    public void testNumberOfBinaryTrees_NonNegativeInput() {
        _3_NumberOfPossibleBnaryTrees treeCounter = new _3_NumberOfPossibleBnaryTrees();
        int result = treeCounter.numberOfbinaryTrees(3);
        assertEquals(5, result);
    }

    @Test
    public void testNumberOfBinaryTrees_ZeroInput() {
        _3_NumberOfPossibleBnaryTrees treeCounter = new _3_NumberOfPossibleBnaryTrees();
        int result = treeCounter.numberOfbinaryTrees(0);
        assertEquals(1, result);
    }

    @Test
    public void testNumberOfBinaryTrees_NegativeInput() {
        _3_NumberOfPossibleBnaryTrees treeCounter = new _3_NumberOfPossibleBnaryTrees();
        // Assuming the method returns 0 for negative input
        int result = treeCounter.numberOfbinaryTrees(-5);
        assertEquals(0, result);
    }

    @Test
    public void testNumberOfBinaryTrees_LargeInput() {
        _3_NumberOfPossibleBnaryTrees treeCounter = new _3_NumberOfPossibleBnaryTrees();
        // Testing with a larger input value
        int result = treeCounter.numberOfbinaryTrees(5);
        assertEquals(42, result);
    }

    @Test
    public void testNumberOfBinaryTrees_EvenInput() {
        _3_NumberOfPossibleBnaryTrees treeCounter = new _3_NumberOfPossibleBnaryTrees();
        int result = treeCounter.numberOfbinaryTrees(4);
        assertEquals(14, result);
    }

    @Test
    public void testNumberOfBinaryTrees_OddInput() {
        _3_NumberOfPossibleBnaryTrees treeCounter = new _3_NumberOfPossibleBnaryTrees();
        int result = treeCounter.numberOfbinaryTrees(7);
        assertEquals(429, result);
    }
}
