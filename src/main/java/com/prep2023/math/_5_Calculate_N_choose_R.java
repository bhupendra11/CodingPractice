package com.prep2023.math;

public class _5_Calculate_N_choose_R {

    public int ncr(int n , int r){

       // int res = factorial(n)/ (factorial(r)* factorial(n-r));
        /*
         n! / (r!) * (n-r)!
                n * (n-1) .....*(n-r-1)
        =>      -----------------------
                 r!
         */

        int res = multiply(n, n-r+1) / factorial(r);

        return res;
    }

    private int multiply(int left, int right) {
        int res = 1;
        while(left >=right){
            res*=left;
            left--;
        }
        return res;
    }

    private int factorial(int n){
        int res =1;

        for(int i=n; i>=1; i--){
            res = res*i;
        }
        return res;
    }
}
