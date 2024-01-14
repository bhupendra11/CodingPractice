package com.bhupendra.prep2023.recursionBacktracking;



import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class _7_N_Queens_ITest {
    private _7_N_Queens_I nQueensSolver;

    @Before
    public void setup() {
        nQueensSolver = new _7_N_Queens_I();
    }

    @Test
    public void testSolveNQueensWithN4() {
        int n = 4;
        int expectedSolutions = 2;

        List<List<String>> solutions = nQueensSolver.solveNQueens(n);

        assertEquals(expectedSolutions, solutions.size());
        // You can add additional assertions to check the validity of the solutions.
    }

    @Test
    public void testSolveNQueensWithN8() {
        int n = 8;
        int expectedSolutions = 92;

        List<List<String>> solutions = nQueensSolver.solveNQueens(n);

        assertEquals(expectedSolutions, solutions.size());
        // You can add additional assertions to check the validity of the solutions.
    }

    @Test
    public void testSolveNQueensWithN0() {
        int n = 0;
        int expectedSolutions = 0;

        List<List<String>> solutions = nQueensSolver.solveNQueens(n);

        assertEquals(expectedSolutions, solutions.size());
    }

    @Test
    public void testSolveNQueensWithN1() {
        int n = 1;
        int expectedSolutions = 1;

        List<List<String>> solutions = nQueensSolver.solveNQueens(n);

        assertEquals(expectedSolutions, solutions.size());
        // You can add additional assertions to check the validity of the solutions.
    }
}
