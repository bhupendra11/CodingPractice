package com.prep2023.graph.sssp_dijikstra_bellmanford;

import java.util.PriorityQueue;

/**
 * Author: Bhupendra Shekhawat
 * Date: 08/12/23
 * Topic: com.prep2023.graph.sssp_dijikstra_bellmanford
 * Question : <a href="https://leetcode.com/problems/path-with-maximum-minimum-value/">. Path With Maximum Minimum Value</a>
 * YouTube : <a href="">Link to YouTube</a>
 *
 *
 *
 * Did This using BFS and selecting max weight node at each step using maxHeap
 *
 * Looks like dijikstra but is not
 */
public class _4_PathWithMaxMinValue {
    int m;
    int n;
    int min;
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    PriorityQueue<Node> pq;
    boolean visited[][];

    public int maximumMinimumPath(int[][] grid) {
        // I can do bfs where I keep selectong the largest weight node using maxHeap
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];
        pq = new PriorityQueue<>((a,b) -> grid[b.x][b.y] - grid[a.x][a.y] );
        pq.add(new Node(0,0));
        min = grid[0][0];

        bfs(grid);
        return min;
    }

    private void bfs(int[][] grid){

        while(!pq.isEmpty()){
            Node node = pq.remove();
            int i = node.x;
            int j = node.y;
            visited[i][j] = true;
            min= Math.min(min, grid[i][j]);
            if(i == m-1 && j == n-1) break;

            for(int k=0;k<=3;k++){
                int x = node.x + dx[k];
                int y = node.y + dy[k];
                if(isValid(x,y) && !visited[x][y]){
                    pq.add(new Node(x,y));
                }
            }
        }

    }

    boolean isValid(int i, int j){
        return i>=0 && i <m && j>=0 && j<n;
    }


    class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
