package com.prep2023.graph.dfs_bfs;

import java.util.*;

/**
 * Author: Bhupendra Shekhawat
 * Date: 13/11/23
 * Topic: com.prep2023.graph.dfs_bfs
 * Question : <a href="https://leetcode.com/problems/detonate-the-maximum-bombs/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 *
 * O(V+E)
 * V = n
 * E = n2
 *
 * We do n bfs where each bfs explores n2 edges
 * @Google
 */
public class _5_DetonateMaxBombs {
    Map<Integer, List<Integer>> map;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
            for(int j=0;j<n;j++){
                if(i==j)continue;
                int r1 = bombs[i][2];
                double dist = dist(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
                if(dist <= r1){
                    map.get(i).add(j);
                }
            }
        }

        int max =0;
        for(int i=0;i<n;i++){
            max = Math.max(max, dfs(i, new HashSet<>()));
        }

        return max;
    }

    private int dfs(int i,Set<Integer> visited){

        visited.add(i);
        int count =1;
        for(int adj : map.get(i)){
            if(!visited.contains(adj)){
                count += dfs(adj,visited);
            }
        }
        return count;
    }

    private double dist(int x1, int y1, int x2, int y2){
        double temp = Math.pow(x2 - x1,2) +  Math.pow(y2 - y1,2) ;
        return Math.sqrt(temp);
    }
}
