package com.prep2023.recursionBacktracking;

public class _8_N_Queens_II {
    int resultCount =0;
    public int totalNQueens(int n) {
        if(n==0)return 0;
        resultCount =0;
        char board[][] = new char[n][n];
        solveNQueens(board,0);
        return resultCount;
    }

    private boolean solveNQueens(char[][] board, int row){
        if(row >= board.length){
            //found a solution
            resultCount++;
            return false; // to initiate backtrack
        }

        //solve for current row
        for(int i=0;i<board.length;i++){
            if(!isValid(board,row,i))continue;
            board[row][i] = 'Q'; //place queen
            if(solveNQueens(board, row+1))return true;
            board[row][i] = '.'; //remove queen
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col){

        // check current col
        for(int i =0;i<row;i++){
            if(board[i][col] == 'Q') return false;
        }

        // no need to check current row as I place only 1 queen per row

        //check upper left diagonal
        int i = row -1;
        int j = col -1;

        for(; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        //check upper right diagonal
        i = row -1;
        j = col +1;

        for(; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
