package com.bhupendra.prep2023.dp.mcm;

import java.util.Arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 16/12/23
 * Topic: com.prep2023.dp.mcm
 * Question : <a href="https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_MatrixChainMultiplication_Memo {

    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][] = new int[N+1][N+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(arr, 1, N-1, dp);
    }

    private static int solve(int arr[], int i, int j , int dp[][]){
        if(i>=j)return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k =i ;k<j;k++){
            int temp = solve(arr, i, k,dp) + solve(arr, k+1,j,dp)
                    + arr[i-1]* arr[k] *arr[j];
            min = Math.min(min, temp);
        }
        dp[i][j] = min;
        return dp[i][j];
    }
}
