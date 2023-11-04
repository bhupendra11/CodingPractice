package com.prep2023.recursionBacktracking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _8_N_Queens_IITest {
    private _8_N_Queens_II nQueensSolver;

    @Before
    public void setup() {
        nQueensSolver = new _8_N_Queens_II();
    }

    @Test
    public void testTotalNQueensWithN0() {
        int n = 0;
        int expectedSolutions = 0;

        int resultCount = nQueensSolver.totalNQueens(n);

        assertEquals(expectedSolutions, resultCount);
    }

    @Test
    public void testTotalNQueensWithN1() {
        int n = 1;
        int expectedSolutions = 1;

        int resultCount = nQueensSolver.totalNQueens(n);

        assertEquals(expectedSolutions, resultCount);
    }

    @Test
    public void testTotalNQueensWithN2() {
        int n = 2;
        int expectedSolutions = 0;

        int resultCount = nQueensSolver.totalNQueens(n);

        assertEquals(expectedSolutions, resultCount);
    }

    @Test
    public void testTotalNQueensWithN3() {
        int n = 3;
        int expectedSolutions = 0;

        int resultCount = nQueensSolver.totalNQueens(n);

        assertEquals(expectedSolutions, resultCount);
    }

    @Test
    public void testTotalNQueensWithN5() {
        int n = 5;
        int expectedSolutions = 10;  // Adjust the expected solution count

        int resultCount = nQueensSolver.totalNQueens(n);

        assertEquals(expectedSolutions, resultCount);
    }
}
