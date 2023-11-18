package com.prep2023.math;

public class _7_LCM {

    public int lcm(int a, int b){
        int gcd = gcd(a,b);
        if(gcd ==0)return 0;
        return a*b/gcd(a,b);
    }

    private int gcd(int a, int b) {
        if(a == 0)return b;
        return gcd(b%a, a);
    }

}
