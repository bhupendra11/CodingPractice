package com.prep2023.dp.lcs;

/**
 * Author: Bhupendra Shekhawat
 * Date: 15/12/23
 * Topic: com.prep2023.dp.lcs
 * Question : <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">Minimum Insertion Steps to Make a String Palindrome</a>
 * YouTube : <a href="">Link to YouTube</a>
 *
 *
 * Same logic should work for
 * Minimum number of deletions to make a string palindrome
 * https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
 */
public class _6_MinimumInsertionStepstoMakeStringPalindrome {

    public int minInsertions(String s) {

        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int m = s1.length();

        //to get common chars I can use lcs

        int dp[][] = new int[m+1][m+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        //lcs => dp[m][n];
        // now the remaining chars are the chars the require chars insertion at complementary places in palindrome

        int ans = s1.length() - dp[m][m];
        return ans;
    }
}
