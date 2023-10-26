package com.codingpractice.backtrackingAndRecursion;

public class ImplementPower {

    public static void main(String[] args) {
        System.out.println(pow(0,5));
        System.out.println(pow(1,5));
        System.out.println(pow(2,5));
        System.out.println(pow(3,4));
    }

    private static int pow(int x, int n){
        if(x==0)return 0;
        if(n==0)return 1;
        if(n==1)return x;

        if(n%2==0){
            return pow(x,n/2)*pow(x,n/2);
        }
        else{
            return x*pow(x,n-1);
        }
    }
}
