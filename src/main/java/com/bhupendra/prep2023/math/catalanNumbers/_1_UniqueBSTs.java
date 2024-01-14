package com.bhupendra.prep2023.math.catalanNumbers;

/**
 * Author: Bhupendra Shekhawat
 * Date: 18/11/23
 * Topic: com.prep2023.math.catalanNumbers
 * Question : <a href="https://leetcode.com/problems/unique-binary-search-trees/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_UniqueBSTs {
    public int numTrees(int n) {

        // for n =1  -> 1
        // for n = 2 -> 2
        // for n = 3 -> 5
        //This 1,2,5.. is catalan numbers pattern
        //so the solution would be nth catalan number
        int sum =0;
        int c[] = new int[n+1];
        c[0] = 1;
        c[1] = 1;

        // C(n+1) = sigma(Ci * C(n-i) )  for i = 0 to n
        for(int i=2;i<=n;i++){
            c[i] =0;

            for(int j=0 ;j<i;j++){
                c[i]  += c[j] * c[i-j-1];
            }
        }
        return c[n];
    }
}
