package com.bhupendra.prep2023.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bhupendra Shekhawat
 * Date: 31/10/23
 * Topic: com.prep2023.graph.dfs_bfs
 * Question : <a href="https://leetcode.com/problems/number-of-provinces/">547. Number of Provinces</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _4_NumberofProvinces_DFS {
    boolean visited[];
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
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