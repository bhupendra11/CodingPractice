package com.bhupendra.prep2023.dp.lcs;

/**
 * Author: Bhupendra Shekhawat
 * Date: 15/12/23
 * Topic: com.prep2023.dp.lcs
 * Question : <a href="https://leetcode.com/problems/delete-operation-for-two-strings/></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _5_MinDeletionOnTwoStrings {
    public int minDistance(String word1, String word2) {
        //we can only delete
        //In one step, you can delete exactly one character in either string.

        // dp[i][j] -> Min no. of deletions to make 0..i and 0..j same
        int m = word1.length();
        int n = word2.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[m][n];
    }
}
