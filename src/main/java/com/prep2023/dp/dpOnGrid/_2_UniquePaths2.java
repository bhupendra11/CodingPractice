package com.prep2023.dp.dpOnGrid;

/**
 * Author: Bhupendra Shekhawat
 * Date: 14/11/23
 * Topic: com.prep2023.dp.dpOnGrid
 * Question : <a href="https://leetcode.com/problems/unique-paths-ii/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _2_UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(m==0 && n ==0)return 0;
        if(m==1 && n==1){
            return obstacleGrid[0][0] == 1 ? 0 : 1;
        }

        if(obstacleGrid[0][0] == 1)return 0;

        //we can use obstackGird as dp array

        //first row
        boolean isObstacle = false;
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i] ==1){
                isObstacle = true;
            }
            if(isObstacle){
                obstacleGrid[0][i] =0;
            }
            else{
                obstacleGrid[0][i] =1;
            }
        }

        // if only 1 row
        if(m==1)return obstacleGrid[0][n-1];

        //first col
        isObstacle = false;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0] ==1){
                isObstacle = true;
            }
            if(isObstacle){
                obstacleGrid[i][0] =0;
            }
            else{
                obstacleGrid[i][0] =1;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1; j<n;j++){
                if(obstacleGrid[i][j] ==1){
                    obstacleGrid[i][j] = 0;
                }
                else{
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
