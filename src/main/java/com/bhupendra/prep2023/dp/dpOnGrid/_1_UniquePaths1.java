package com.bhupendra.prep2023.dp.dpOnGrid;

import java.util.Arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 14/11/23
 * Topic: com.prep2023.dp.dpOnGrid
 * Question : <a href="https://leetcode.com/problems/unique-paths/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_UniquePaths1 {

    public int uniquePaths(int m, int n){

        //just need two rows
        int row1[] = new int[n];
        int row2[] = new int[n];

        Arrays.fill(row1, 1); //reach 0th row with 1 way
        row2[0] =1;


        int rows=1;
        while(rows<=m){

            for(int i=1 ;i<n ;i++){
                row2[i] = row1[i] + row2[i-1];
            }
            rows++;

            //swap
            int temp[] = row2;
            row2 = row1;
            row1 = temp;
        }

        return row2[n-1];
    }


    // public int uniquePaths(int m, int n) {

    //     int dp[][] = new int[m][n];

    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(i==0 || j==0){
    //                 dp[i][j] =1;
    //             }
    //             else{
    //                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
    //             }
    //         }
    //     }

    //     return dp[m-1][n-1];
    // }
}