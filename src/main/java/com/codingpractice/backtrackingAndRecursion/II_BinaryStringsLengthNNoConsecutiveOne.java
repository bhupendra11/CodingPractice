package com.codingpractice.backtrackingAndRecursion;

/**
 * Calculate number of binary strings with length N and which have only consecutive 1
 */
public class II_BinaryStringsLengthNNoConsecutiveOne {
    public static void main(String[] args) {
        System.out.println(binaryStrings(2));
        System.out.println(binaryStrings(3));
        System.out.println(binaryStrings(4));
        System.out.println(binaryStrings(5));

    }
    // It is a problem similar to fibonacci and fibonacci relation works here
    // f(n) = f(n-1) + f(n-2)
    private static int binaryStrings(int n){
        if(n==0)return 0;
        if(n==1)return 2;
        if(n==2)return 3;

        return binaryStrings(n-1)+binaryStrings(n-2);


    }
}

