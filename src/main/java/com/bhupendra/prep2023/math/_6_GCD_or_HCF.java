package com.bhupendra.prep2023.math;

public class _6_GCD_or_HCF {

    public int gcd(int a, int b){
        if(a == 0)return b;

        return gcd(b%a,a);
    }
}
