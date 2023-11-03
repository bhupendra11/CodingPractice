package com.prep2023.graph.mst;

import java.util.Arrays;

public class MinCostUsingKruskals {
    public int minimumCost(int n, int[][] connections) {
        // Lets use Kruskal's MST algorithm to do this

        // In the algo, we keep finding the smallest weight edge and try creating the graph, if we find a redundant edge, which will cause cycle, we ignore it

        // We can use DSUF to find redundant edge
        UnionFind uf = new UnionFind(n+1);

        //Sort all edges in increasing order of weight
        Arrays.sort(connections, (x, y)-> x[2] - y[2]);

        int cost =0;
        int usedEdges =0;
        for(int i=0;i<connections.length;i++){
            int[] edge = connections[i];
            int u = edge[0];
            int v = edge[1];

            if(!uf.isConnected(u,v)){
                uf.union(u,v);
                cost+= edge[2];
                usedEdges++;
            }
        }

        //If  the MST is formed with minimumn edges, total min edges to connect n nodes will be n-1

        if(usedEdges != n-1) return -1;
        return cost;
    }

    private class UnionFind{
        int rank[];
        int root[];

        public UnionFind(int n){
            this.rank = new int[n];
            this.root = new int[n];
            for(int i=0;i<n;i++){
                root[i] = i;
            }
        }

        int find(int x){
            if(x == root[x]){
                return x;
            }
            return root[x] = find(root[x]);
        }

        void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }
            else if(rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            }
            else{
                root[rootY] = rootX;
                rank[rootY] += 1;
            }
        }

        boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}