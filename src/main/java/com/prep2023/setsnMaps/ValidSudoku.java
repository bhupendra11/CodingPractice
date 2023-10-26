package com.prep2023.setsnMaps;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Bhupendra Shekhawat
 * Date: 24/10/23
 * Topic: com.prep2023.setsnMaps
 * Question Link: https://leetcode.com/problems/valid-sudoku/description/
 * YouTube Link: 
 * Problem: 36. Valid Sudoku MEDIUM
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

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

    public static void main(String[] args) {
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

        ValidSudoku solution = new ValidSudoku();
        boolean isValidSudoku = solution.isValidSudoku(board);

        System.out.println("Is the Sudoku board valid? " + isValidSudoku);

        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Is the Sudoku board 2 valid? " + solution.isValidSudoku(board2));
    }
}
