package com.bhupendra.prep2023.recursionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _7_N_Queens_I {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n==0)return result;
        char[][] board = getNewBoard(n);
        solveNQueens(n, 0, board);
        return result;
    }

    private boolean solveNQueens(int queensRemaining, int row, char[][] board) {
        if (row >= board.length) {
            //all queens are placed
            addToResult(board);
            return false; //initiate backtrack, to get multiple solutions
        }
        // Place queen row wise
        for (int j = 0; j < board.length; j++) {
            if (!isValid(board, row, j)) continue;
            board[row][j] = 'Q';
            if (solveNQueens(queensRemaining - 1, row + 1, board)) return true;
            board[row][j] = '.';
        }
        return false;
    }

    private void addToResult(char[][] board) {
        List<String> placement = new ArrayList<>();
        for (char[] arr : board) {
            placement.add(new String(arr));
        }
        result.add(placement);
    }

    private char[][] getNewBoard(int n) {
        // returns n*n empty board
        char[][] board = new char[n][n];
        char[] arr = new char[n];
        Arrays.fill(arr, '.');

        for (int i = 0; i < n; i++) {
            board[i] = arr.clone();
        }
        return board;
    }

    private boolean isValid(char[][] board, int row, int col) {
        //check vertically , in same col
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        //same row check is not required as I place only 1 queen in 1 row

        //check upper left diagonal
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            //System.out.println("At i = "+i+" j="+j);
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        //check upper right diagonal
        i = row - 1;
        j = col + 1;
        while (i >=0  && j <board.length) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }


    public static void main(String[] args) {
        _7_N_Queens_I nQueensI = new _7_N_Queens_I();
        List<List<String>> result = nQueensI.solveNQueens(4);
        System.out.println(result);

    }
}
