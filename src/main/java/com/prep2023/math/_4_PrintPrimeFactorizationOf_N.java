package com.prep2023.math;

/*
The idea is to keep divind the number N starting with 2 will it is divisible by 2
and then move on to dividing it by next prime number i.e. 3 and so on will possib;e

Eg : 10  = 2*5
Eg 20 = 2*2*5
Eg 24 = 2*2*2*3
 */
public class _4_PrintPrimeFactorizationOf_N {

    static void printPrimeFactorization(int n){
        //for every prime number
        for(int i=2 ;i<Math.sqrt(n);i++){
            while(n%i ==0) { // till n in not divisible by i , keep dividing it by i
                n = n / i;
                System.out.print(i + " * ");
            }
        }

        if(n > 1){
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        printPrimeFactorization(10);
        printPrimeFactorization(24);
        printPrimeFactorization(90);
        printPrimeFactorization(249);
        printPrimeFactorization(5490);
    }
}
