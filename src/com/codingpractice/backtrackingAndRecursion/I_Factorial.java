package com.codingpractice.backtrackingAndRecursion;

public class I_Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(15));
        System.out.println(factorial(3));
    }

    private static int factorial(int n){
        if(n==0)return 1;
        return n * factorial(n-1);
    }
}
