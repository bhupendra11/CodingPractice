package com.prep2023.dp.knapsack;

import java.util.Arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 14/12/23
 * Topic: com.prep2023.dp.knapsack
 * Question : <a href="https://leetcode.com/problems/coin-change-ii/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class CoinChange_II_Tabulation {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        //you have an infinite number of each kind of coin.
        for(int i=0;i<=n ;i++){
            for(int j=0;j<=amount ;j++){
                if(i == 0){
                    dp[i][j] = (j==0) ? 1 : 0;
                }
                else if(j ==0){
                    dp[i][j] = 1;
                }
                else if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}