package com.prep2023.recursionBacktracking;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class _1SudokuSolverTest {
    @Test
    public void testSolveSudoku1() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        _1SudokuSolver solver = new _1SudokuSolver();
        solver.solveSudoku(board);

        assertTrue(isValidSudoku(board));
    }

    @Test
    public void testSolveSudoku2() {
        char[][] board = {
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '3', '6', '.', '.', '.', '.', '.'},
                {'.', '7', '.', '.', '9', '.', '2', '.', '.'},
                {'.', '5', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '.', '4', '5', '7', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '.', '3', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '6', '8'},
                {'.', '.', '8', '5', '.', '.', '.', '1', '.'},
                {'.', '9', '.', '.', '.', '.', '4', '.', '.'}
        };

        _1SudokuSolver solver = new _1SudokuSolver();
        solver.solveSudoku(board);

        assertTrue(isValidSudoku(board));
    }

    // Add more test cases as needed

    private boolean isValidSudoku(char[][] board) {

        if(!validateCols(board))return false;

        if(!validateRows(board))return false;

        for(int i=0; i<9; i+=3){
            for(int j=0;j<9; j+=3){
                if(!validateSmallBox(board,i,j))return false;
            }
        }
        return true;

    }
    private boolean validateRows(char[][] board){
        Set<Character> set;
        for(int j=0;j<9;j++){
            set = new HashSet<>();
            for(int i=0;i<9;i++){
                if(set.contains(board[i][j])) return false;
                if(board[i][j] != '.'){
                    set.add(board[i][j]);
                }
            }
        }
        return true;

    }

    private boolean validateCols(char[][] board){
        Set<Character> set;
        for(int i=0;i<9;i++){
            set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(set.contains(board[i][j])) return false;
                if(board[i][j] != '.'){
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

    private boolean validateSmallBox(char[][] board, int x, int y){
        Set<Character> set = new HashSet<>();
        for(int i=x ;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(set.contains(board[i][j]))return false;
                if(board[i][j] != '.'){
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
}