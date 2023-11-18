package com.prep2023.math.catalanNumbers;


/**
 * A rooted binary tree with roiot node where each node has either zero or 2 branches descending from it
 *
 * 0 child -> leaf node
 * 2 child -> internal node
 *
 * How many rooted binary trees are there with N internal nodes
 */
public class _3_NumberOfPossibleBnaryTrees {

    public int numberOfbinaryTrees(int n){
        if(n <0)return  0;
        if(n==0 || n==1)return 1;

        int catalan[] = new int[n+1];
        catalan[0] = catalan[1] = 1;

        for(int i=2; i<=n ;i++){
            catalan[i] =0;
            for(int j=0; j<i ;j++){
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }
        return  catalan[n];
    }
}
