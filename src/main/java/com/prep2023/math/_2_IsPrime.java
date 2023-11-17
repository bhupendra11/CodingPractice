package com.prep2023.math;

public class _2_IsPrime {

    public static void main(String[] args) {
        testIsPrime(9, false);
        testIsPrime(11, true);
        testIsPrime(25, false);
        testIsPrime(29, true);
        testIsPrime(37, true);
        testIsPrime(1, false);   // Edge case: 1 is not a prime number
        testIsPrime(2, true);    // Edge case: 2 is a prime number
        testIsPrime(0, false);   // Edge case: 0 is not a prime number
        testIsPrime(-5, false);  // Edge case: Negative numbers are not prime
    }

    private static void testIsPrime(int n, boolean expectedResult) {
        System.out.println("isPrime(" + n + ") = " + isPrime(n) + " (Expected: " + expectedResult + ")");
    }
    private static boolean isPrime(int n) {
        if(n<2)return false;
        for(int i=2 ;i<=Math.sqrt(n);i++){
            if(n%i ==0)return false;
        }
        return true;
    }
}
