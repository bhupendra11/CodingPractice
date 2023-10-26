package com.codingpractice.dynamicProgramming.I_01knapsack;

public class I_01Knapsack_TopDown {

    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int values[] = {1,2,3};
        int weight[] = {4,5,1};

        System.out.println(knapSack(W,weight,values,N));

        N = 3;
        W = 3;
        values = new int[]{1,2,3};
        weight = new int[]{4,5,6};

        System.out.println(knapSack(W,weight,values,N));
    }

    static int mat[][] ;

    static int knapSack(int W, int wt[], int val[], int n)
    {
        mat = new int[W+1][n+1];
        for(int i=0;i<W;i++){
            for(int j=0;j<n;j++){
                mat[i][j] =-1;
            }
        }

        return knap(W,wt,val,n);
    }

    static int knap(int w, int wt[], int val[], int n){
        if(n==0 || w==0){
            return 0;
        }

        if(mat[w-1][n-1] !=-1)return mat[w-1][n-1];

        if(wt[n-1]<=w){
            mat[w-1][n-1] = Math.max(val[n-1] +knap(w-wt[n-1],wt,val,n-1), knap(w,wt,val,n-1));
        }
        else{
            mat[w-1][n-1] = knap(w,wt,val,n-1);
        }
        return mat[w-1][n-1] ;
    }

}
