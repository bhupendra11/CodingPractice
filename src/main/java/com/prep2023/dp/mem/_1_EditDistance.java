package com.prep2023.dp.mem;

/**
 * Author: Bhupendra Shekhawat
 * Date: 14/11/23
 * Topic: com.prep2023.dp.mem_mcm
 * Question : <a href="https://leetcode.com/problems/edit-distance/">72. Edit Distance</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1.isEmpty() && word2.isEmpty())return 0;
        if(word1.isEmpty())return word2.length();
        if(word2.isEmpty())return word1.length();
        // I can do 3 operations
        // i -> points to last char of word1
        // j -> points to last char of word2

        //1 Insertion :
        // For insertion I will add character in word1 which is same as last character of word2
        // which will cause a match leading to removal of last char in both strings ->  i, j-1

        //2 Deletion
        // When no match, delete the character in  word1
        // i-1, j

        //3 Replace character
        // When no match , replace last character in word1 with last character of word2, which will cause a match leading to removal of last char in both strings
        // i-1, j-1

        int m = word1.length();
        int n = word2.length();

        int dp[][] = new int[m+1][n+1];

        //fill 1st col, representing empty word1
        for(int i=0;i<=m;i++){
            dp[i][0] = i;
        }

        //fill 1st row
        for(int i=0;i<=n;i++){
            dp[0][i] = i;
        }

        for(int i=1;i<=m;i++){
            for(int j=1; j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+ Math.min(
                            dp[i][j-1], //INSERT
                            Math.min(
                                    dp[i-1][j], //DELETE
                                    dp[i-1][j-1]  //REPLACE
                            )
                    );
                }
            }
        }
        return dp[m][n];
    }
}
