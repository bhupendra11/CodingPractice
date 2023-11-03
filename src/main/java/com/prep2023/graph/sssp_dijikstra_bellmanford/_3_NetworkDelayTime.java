package com.prep2023.graph.sssp_dijikstra_bellmanford;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Bhupendra Shekhawat
 * Date: 03/11/23
 * Topic: com.prep2023.graph
 * Question : <a href="https://leetcode.com/problems/network-delay-time/?envType=list&envId=53js48ke">743. Network Delay Time</a>
 * YouTube : <a href="">Link to YouTube</a>
 *
 * Done using Dijikstra's algo
 */
public class _3_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int maxTime = 0;
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int edge[] : times) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        //dijikstra's shortest path algorithms would work here
        boolean visited[] = new boolean[n + 1];
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        //do till v-1 iterations
        for (int i = 0; i < n; i++) {
            int node = findMinDistNode(dist, visited); //shortest dist node
            visited[node] = true;
            //relax all its neighbors
            for (Pair pair : adjList.get(node)) {
                int nbr = pair.node;
                int distance = pair.dist;
                dist[nbr] = Math.min(dist[nbr], dist[node] + distance);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > max) {
                max = dist[i];
            }
        }
        return max == Integer.MAX_VALUE ? -1 : max;

    }

    private int findMinDistNode(int distance[], boolean visited[]) {
        int min = -1;
        for (int i = 1; i < distance.length; i++) {

            if (!visited[i] && (min == -1 || distance[i] < distance[min])) {
                min = i;
            }
        }
        return min;
    }

    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        _3_NetworkDelayTime networkDelayTime = new _3_NetworkDelayTime();

        // Example 1
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n1 = 4;
        int k1 = 2;
        int result1 = networkDelayTime.networkDelayTime(times1, n1, k1);
        System.out.println("Example 1 Output: " + result1); // Expected output: 2

        // Example 2
        int[][] times2 = {{1, 2, 1}};
        int n2 = 2;
        int k2 = 1;
        int result2 = networkDelayTime.networkDelayTime(times2, n2, k2);
        System.out.println("Example 2 Output: " + result2); // Expected output: 1

        // Example 3
        int[][] times3 = {{1, 2, 1}};
        int n3 = 2;
        int k3 = 2;
        int result3 = networkDelayTime.networkDelayTime(times3, n3, k3);
        System.out.println("Example 3 Output: " + result3); // Expected output: -1
    }

    // Rest of the _3_NetworkDelayTime class methods here...


}
