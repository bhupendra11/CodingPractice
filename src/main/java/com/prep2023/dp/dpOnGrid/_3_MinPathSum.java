package com.prep2023.dp.dpOnGrid;

/**
 * Author: Bhupendra Shekhawat
 * Date: 14/11/23
 * Topic: com.prep2023.dp.dpOnGrid
 * Question : <a href="https://leetcode.com/problems/minimum-path-sum/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _3_MinPathSum {
    public int minPathSum(int[][] grid) {
        //use given grid as dp grid
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m ;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0 ){continue;}
                else if(i==0){
                    grid[i][j] += grid[i][j-1];
                }
                else if(j==0){
                    grid[i][j] += grid[i-1][j];
                }
                else{
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }

        return grid[m-1][n-1];
    }
}
