package com.bhupendra.prep2023.trees;

import java.util.ArrayList;
import java.util.List;

public class MaximumScoreAfterOperations {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        
        int maxScoreSubtree[] = new int[n];
        int sumScoreSubtree[] = new int[n];
        
        TreeNode[] nodes = new TreeNode[n];
        for(int i=0;i<n;i++){
            nodes[i] = new TreeNode(i,values[i]);
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            nodes[u].neighbors.add(nodes[v]);
            nodes[v].neighbors.add(nodes[u]);
        }
        
        dfs(nodes[0],  null, maxScoreSubtree, sumScoreSubtree );
        
        if(sumScoreSubtree[0] ==0){
            return 0;
        }
        return maxScoreSubtree[0];
    }
    
    void dfs(TreeNode node, TreeNode parent, int maxScoreSubtree[], int sumScoreSubtree[]){
        
        maxScoreSubtree[node.node] = node.val;
        sumScoreSubtree[node.node] = node.val;
        
        for(TreeNode nbr: node.neighbors){
            
            if(nbr == parent){
                //skip to avoid loop
                continue;
            }
            
            dfs(nbr, node, maxScoreSubtree, sumScoreSubtree);
            
            maxScoreSubtree[node.node] += Math.max(0, maxScoreSubtree[nbr.node]);
            sumScoreSubtree[node.node] += sumScoreSubtree[nbr.node];
        }
        
    }

    public static void main(String[] args) {
        MaximumScoreAfterOperations solution = new MaximumScoreAfterOperations();

        // Example 1
        int[][] edges1 = {{0,1},{0,2},{0,3},{2,4},{4,5}};
        int[] values1 = {5,2,5,2,1,1};
        System.out.println(solution.maximumScoreAfterOperations(edges1, values1));  // Output: 11

        // Example 2
        int[][] edges2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values2 = {20,10,9,7,4,3,5};
        System.out.println(solution.maximumScoreAfterOperations(edges2, values2));  // Output: 40
    }
    
    
    class TreeNode{
        int node;
        int val;
        List<TreeNode> neighbors;
        
        TreeNode(int node, int val){
            this.node = node;
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
}