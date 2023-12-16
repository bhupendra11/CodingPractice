package com.prep2023.dp.knapsack;

import java.util.Arrays;

public class CoinChange_II_Memo {
    int dp[][];
    public int change(int amount, int[] coins) {

        dp = new int[coins.length+1][amount+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return numWays(0, coins, amount);
    }

    private int numWays(int index, int[] coins, int amount){
        if(index >= coins.length)return 0;
        if(amount == 0)return 1;

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        if(coins[index] > amount){ //can only skip
            dp[index][amount] = numWays(index +1, coins, amount);
        }
        else{
            dp[index][amount] = numWays(index, coins, amount - coins[index]) //take
                    +  numWays(index +1, coins, amount);
        }
        return dp[index][amount];
    }
}
