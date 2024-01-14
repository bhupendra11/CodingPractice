package com.bhupendra.prep2023.math;

import java.util.Arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 16/11/23
 * Topic: com.prep2023.math
 * Question : <a href="https://leetcode.com/problems/count-primes/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_AllPrimesFrom1toN {
    public static int countPrimes(int n) {

        boolean primes[] = new boolean[n+1];
        //consider all as primes initially
        Arrays.fill(primes,true);

        //only need to check till sqrt as every factor is in pairs
        for(int i=2;i<Math.sqrt(n);i++){
            if(primes[i]){
                //mark all multiples as non prime
                for(int j =2*i ;j<n; j+=i){
                    primes[j] = false;
                }
            }
        }
        int count =0;
        for(int i=2;i<n;i++){
            if(primes[i])count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10)); // 2 3 5 7  => 4
    }
}
