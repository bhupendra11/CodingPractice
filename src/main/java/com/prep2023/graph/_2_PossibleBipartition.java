package com.prep2023.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _2_PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // This is basically a grpah bipartition problem
        // Where dislikes contains the relevant edges in the graph
        // so we need to create adjList

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        //since the edges are givesn 1 based, lets make them 0 based
        // Also , lack of clarity inb question, but the dislikes are bidirectional
        for(int edge[] : dislikes){
            adjList.get(edge[0]-1).add(edge[1]-1);
            adjList.get(edge[1]-1).add(edge[0]-1);
        }

        // We can do the bipartition check using DFS with graph coloring with 2 colors

        int color[] = new int[n];
        Arrays.fill(color, -1);

        for(int node =0; node <n;node++){
            if(color[node] ==-1){ // if not processed already in DFS

                color[node] =0;
                Stack<Integer> stack = new Stack<>();
                stack.add(node);

                while(!stack.isEmpty()){
                    int curNode = stack.pop();

                    //try coloring all neighbors with complementary colors
                    for(int neighbor : adjList.get(curNode) ){
                        if(color[neighbor] == -1){
                            stack.push(neighbor);
                            color[neighbor] = color[curNode] ^1;
                        }
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
