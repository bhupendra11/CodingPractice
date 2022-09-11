package com.codingpractice.dynamicProgramming.dpAdityav.I_01Knapsack;

public class I_KnapsackRecursive {
    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int values[] = {1,2,3};
        int weight[] = {4,5,1};

        System.out.println(knapsackRec(values,weight,N,W));

        N = 3;
        W = 3;
        values = new int[]{1,2,3};
        weight = new int[]{4,5,6};

        System.out.println(knapsackRec(values,weight,N,W));
    }

    private static int knapsackRec(int values[],int weight[], int n, int w ){
        if(n==0 | w==0)return 0;

        if(weight[n-1] <= w){
            return Math.max(values[n-1]+knapsackRec(values,weight,n-1,w-weight[n-1]),
                    knapsackRec(values,weight,n-1,w)
                    );
        }
        return knapsackRec(values,weight,n-1,w);
    }
}
