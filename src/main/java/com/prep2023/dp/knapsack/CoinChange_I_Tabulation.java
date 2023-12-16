package com.prep2023.dp.knapsack;

import java.util.Arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 23/11/23
 * Topic: com.prep2023.dp.knapsack
 * Question : <a href="https://leetcode.com/problems/coin-change/">Coin Change I</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class CoinChange_I_Tabulation {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        // dp[i] stores min number of coins to achieve amount i
        dp[0] = 0;
        for(int i=1;i<=amount ;i++){
            for(int coin : coins){
                if(i - coin < 0 )continue;
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}