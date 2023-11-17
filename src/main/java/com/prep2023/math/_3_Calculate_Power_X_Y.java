package com.prep2023.math;

public class _3_Calculate_Power_X_Y{
    static int power(int a, int b){
        boolean isNegativeExpo = false;
        if(b <0){
            isNegativeExpo = true;
            b = Math.abs(b);
        }

        int result =1;

        while(b >0){
            if(b%2 ==1){
                result *= a;
            }
            a *= a;  //square the base
            b /= 2;  // half the power
        }
        if(isNegativeExpo)return 1/result;
        return result;
    }
}
