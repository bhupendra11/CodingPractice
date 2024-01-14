package com.bhupendra.prep2023.dp.lcs;

/**
 * Author: Bhupendra Shekhawat
 * Date: 11/11/23
 * Topic: com.prep2023.dynamicProgramming.lcs
 * Question : <a href="https://leetcode.com/problems/longest-common-subsequence/">1143. Longest Common Subsequence</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_LongestCommonSubsequenceBottomUp {
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null)return 0;
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m+1][n+1];

        //dp[i][j] -> lcs for substrings 0..i and 0..j

        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcab", "cbab"));
    }
}
