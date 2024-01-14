package com.bhupendra.prep2023.graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * Author: Bhupendra Shekhawat
 * Date: 02/11/23
 * Topic: com.prep2023.graph
 * Question : <a href="https://leetcode.com/problems/is-graph-bipartite/">785. Is Graph Bipartite?</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        // A tree is a bipartite graph
        // A graph with even length cycle is also bipartite
        // BUT a graph with odd length cycle is not bipartite, if you trye to make two discjoint sets, you cant

        // SO all I need to do is find if there is an odd length cycle or not

        // Lets use DFS graph coloring with 2 colors(T/F)
        // at every edge , I will check if the connected edges has opposite color
        // TC O(V+E)
        // SC O(V). - color array


        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);

        boolean isCycle = false;

        for(int node=0; node<n;node++){  //makes sure all node are attempted to be colored
            if(color[node] == -1){ //node not processed

                Stack<Integer> stack = new Stack<>();
                stack.push(node);
                color[node] = 0;

                while(!stack.isEmpty()){
                    int curNode = stack.pop();
                    for(int neighbor : graph[curNode]){
                        if(color[neighbor] == -1){
                            stack.push(neighbor);
                            //assign complementary color to neighbor
                            color[neighbor] = color[curNode] ^ 1;
                        }
                        //if ever a neighbor and curNode's color are same, their is odd length cycle
                        if(color[neighbor] == color[curNode]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }
}
