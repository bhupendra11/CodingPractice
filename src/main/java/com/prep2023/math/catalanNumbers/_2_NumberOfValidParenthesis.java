package com.prep2023.math.catalanNumbers;

public class _2_NumberOfValidParenthesis {

    int validParenthesis(int n){
        if(n<=1) return 1;
        int catalan[] = new int[n+1];
        catalan[0] =1;
        catalan[1] = 1;



        for(int i=2;i<=n;i++){
            catalan[i] =0;
            for(int j=0;j<i;j++){
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }
        return catalan[n];
    }
}
