package com.bhupendra.prep2023.graph.apsp_floyd_warshall;

import java.util.HashMap;
import java.util.Map;

public class CityWithSmallestNumberOfNeighborsAtThreashold {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        long dist[][] = new long[n][n];
        //initialize dist
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //no self loops
                if(i==j){
                    dist[i][j] = 0;
                }
                else {
                    dist[i][j] = Integer.MAX_VALUE;
                }

            }
        }

        //add edges
        for(int edge[] : edges){
            int i = edge[0];
            int j = edge[1];
            int w = edge[2];
            //edges are bi-directional
            dist[i][j] = w;
            dist[j][i] = w;
        }

        //perform traversal using Floyd -warshall APSP

        for(int k =0; k<n;k++){ //do V iterations
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+ dist[k][j]);
                }
            }
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        int resultCity = 0;
        for(int city=0; city<n; city++){
            countMap.put(city,0);
            for(int nbr=0; nbr<n; nbr++){
                if(nbr ==city)continue;
                if(dist[city][nbr] <= distanceThreshold){
                    countMap.put(city, countMap.get(city)+1);
                }
            }
        }

        for(int city=0; city<n; city++){
            if(countMap.get(city) <  countMap.get(resultCity)
                    ||
                    (city > resultCity && countMap.get(city) <= countMap.get(resultCity)))
            {
                resultCity = city;
            }
        }
        return resultCity;
    }
}
