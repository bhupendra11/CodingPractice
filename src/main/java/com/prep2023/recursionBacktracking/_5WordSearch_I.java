package com.prep2023.recursionBacktracking;

/**
 * Author: Bhupendra Shekhawat
 * Date: 26/10/23
 * Topic: com.prep2023.recursionBacktracking
 * Question Link: https://leetcode.com/problems/word-search/
 * YouTube Link: 
 * Problem: 
 */


// Beats 25%, memory is inconsistent, shows beats 25% at times , and sometimes beats 96%
public class _5WordSearch_I {
    int m ;
    int n;
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    char[][] board;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length ==0)return false;

        this.m = board.length;
        this.n = board[0].length;
        this.board = board;



        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( backtrack(word,0,i,j)){
                    return true;
                }

            }
        }
        return false;
    }

    private boolean backtrack(String target, int index, int i, int j){
        if(index >= target.length()){
            return true;
        }

        //check if current character matches
        if(!isValid(i,j) || board[i][j] != target.charAt(index) ){
            return false;
        }

        //mark current visited
        board[i][j] = '#';

        for(int k=0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            //return without cleanup if found
            if(backtrack(target,index+1,x,y)) return true;
        }

        //cleanup the visited marking done earlier
        board[i][j] = target.charAt(index);
        return false;
    }

    private boolean isValid(int i, int j){
        return i >=0 && i<m && j>=0 && j<n;
    }
}


//MinCostUsingKruskals 1
// Passes LC test cases but only beats 5% , not good
// Also takes good storage space and only beats 5% in space also
/*
class MinCostUsingKruskals {
    int m ;
    int n;
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    public boolean exist(char[][] board, String word) {

        this.m = board.length;
        this.n = board[0].length;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0) == board[i][j]){
                    Set<String> visited = new HashSet<>();
                    visited.add(i+"|"+j);
                   if( backtrack(board, word,new StringBuilder(board[i][j]+""), i,j, visited)){  // store x|y in hashset
                        return true;
                   }
                }
            }
        }
        return false;

    }

    private boolean backtrack(char[][] board, String target,StringBuilder soFar, int i, int j, Set<String> visited){
        if(soFar.toString().equals(target)){
            return true;
        }

        for(int k=0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];

            if(isValid(x,y,visited) && board[x][y] == target.charAt(soFar.length())){ //found next match
                soFar.append(board[x][y] +"");
                visited.add(x+"|"+y);
                if(backtrack(board,target, soFar, x,y,visited)){
                    return true;
                }
                soFar.deleteCharAt(soFar.length()-1);
                visited.remove(x+"|"+y);
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, Set<String> visited){
        return i >=0 && i<m && j>=0 && j<n && !visited.contains(i+"|"+j);
    }
}
 */