package com.prep2023.dynamicProgramming.lcs;

/**
 * Author: Bhupendra Shekhawat
 * Date: 11/11/23
 * Topic: com.prep2023.dynamicProgramming.lcs
 * Question : <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">516. Longest Palindromic Subsequence</a>
 * YouTube : <a href="">Link to YouTube</a>
 */

//This can be further oiptimised with O(n) storage
public class _2_LongestPalindromicSubsequence {
        public int longestPalindromeSubseq(String s1) {
            //its longest common subsequence with the second
            //string being the reverse of the first one
            String s2 = new StringBuilder(s1).reverse().toString();
            int m = s1.length();
            int n = s2.length();

            int dp[][] = new int[m+1][n+1];

            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    if(i==0 || j==0){
                        dp[i][j] = 0;
                        continue;
                    }
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[m][n];
        }
    }