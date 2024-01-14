package com.bhupendra.prep2023.recursionBacktracking;

public class _1SudokuSolver {

    public void solveSudoku(char[][] board) {

        if(board == null || board.length==0)return;
        solve(board);

    }

    private boolean solve(char[][] board){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.') continue;

                for(char c = '1' ; c <='9' ; c++){
                    if(isValid(board,i,j,c)){
                        //place on board
                        board[i][j] = c;
                        if(solve(board))return true;
                        //remove from board
                        board[i][j] = '.';
                    }
                }
                return false;

            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col , char num){
        int regionRow = 3 * (row / 3);  //region start row
        int regionCol = 3 * (col / 3);    //region start col
        for(int i=0;i<9;i++){
            //check rows
            if(board[i][col] ==num)return false;
            //check cols
            if(board[row][i] ==  num)return false;

            //check current 3*3 box
            if(board[regionRow + i/3][regionCol+i%3] == num)return false;
        }
        return true;
    }
}
