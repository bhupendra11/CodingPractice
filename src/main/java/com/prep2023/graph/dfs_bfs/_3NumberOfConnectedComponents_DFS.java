package com.prep2023.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bhupendra Shekhawat
 * Date: 31/10/23
 * Topic: com.prep2023.graph.dfs_bfs
 * Question : <a href="https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/">323. Number of Connected Components in an Undirected Graph</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _3NumberOfConnectedComponents_DFS {
    boolean visited[];
    public int countComponents(int n, int[][] edges) {
        //Approach 1 DFS
        //undirected graph

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        visited = new boolean[n];

        int count=0;
        for(int i=0 ;i<n ;i++){
            if(!visited[i]){
                dfs(i, adjList);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, List<List<Integer>> adjList ){

        visited[node] = true;

        for(int neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adjList);
            }
        }
    }
}
