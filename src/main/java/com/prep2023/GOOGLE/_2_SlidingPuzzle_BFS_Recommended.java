package com.prep2023.GOOGLE;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Bhupendra Shekhawat
 * Date: 15/11/23
 * Topic: com.prep2023.GOOGLE
 * Question : <a href="https://leetcode.com/problems/sliding-puzzle/description/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _2_SlidingPuzzle_BFS_Recommended {

    int dx[] = {0, 0, 1, -1};
    int dy[] = {-1, 1, 0, 0};
    int ans = Integer.MAX_VALUE;

    //stores the minimum distance to reach a board configuration
    // if we reach the board in more steps in later move, simply return
    Map<String, Integer> visited = new HashMap<>();

    public int slidingPuzzle(int[][] board) {
        // this is backtraking
        int ideal[][] = {{1, 2, 3}, {4, 5, 0}};
        int m = ideal.length;
        int n = ideal[0].length;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    dfs(i, j, board, 0);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int i, int j, int board[][], int dist) {
        if (isSolved(board)) {
            ans = Math.min(dist, ans);
        }

        String hash = boardHash(board);
        if (visited.getOrDefault(hash, Integer.MAX_VALUE) < dist) {
            return;
        }
        visited.put(hash, dist);

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (isValid(x, y)) {

                //swap
                swap(board, i, j, x, y);

                dfs(x, y, board, dist + 1);

                //backtrack
                swap(board, i, j, x, y);
            }
        }
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < 2 && j >= 0 && j < 3;
    }

    private void printBoard(int[][] arr) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void swap(int arr[][], int i, int j, int x, int y) {
        //  System.out.println("Swap arr["+i+"]["+j+"] with arr["+x+"]["+y+"]");
        int temp = arr[i][j];
        arr[i][j] = arr[x][y];
        arr[x][y] = temp;
    }

    private boolean isSolved(int board[][]) {
        int required[][] = {{1, 2, 3}, {4, 5, 0}};

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != required[i][j]) return false;
            }
        }
        return true;
    }

    //Save the entire board state as a string
    private String boardHash(int board[][]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j] + "");
            }
        }
        return sb.toString();
    }

}