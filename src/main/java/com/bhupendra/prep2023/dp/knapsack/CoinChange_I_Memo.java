package com.bhupendra.prep2023.dp.knapsack;

/**
 * Author: Bhupendra Shekhawat
 * Date: 23/11/23
 * Topic: com.prep2023.dp.knapsack
 * Question : <a href="https://leetcode.com/problems/coin-change/">Coin Change I</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class CoinChange_I_Memo {
    Integer dp[];

    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount + 1];
        int ans = coinChangeHelper(coins, amount);

        return ans;
    }

    public int coinChangeHelper(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int ans = Integer.MAX_VALUE;

        if (dp[amount] != null) return dp[amount];

        for (int coin : coins) {
            int res = coinChangeHelper(coins, amount - coin);
            if (res == -1) continue;
            ans = Math.min(ans, res + 1);
        }

        dp[amount] = ans == Integer.MAX_VALUE ? -1 : ans;

        return dp[amount];

    }
}
