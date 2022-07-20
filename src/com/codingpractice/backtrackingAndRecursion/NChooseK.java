package com.codingpractice.backtrackingAndRecursion;

public class NChooseK {
    public static void main(String[] args) {
        System.out.println(nChooseK(3,2));
        System.out.println(nChooseK(10,7));
        System.out.println("DONE");
    }

    private static  int nChooseK(int n , int k){
        if(k==0 || k==n)return 1;

        return nChooseK(n-1,k-1) + nChooseK(n-1,k);
    }
}
