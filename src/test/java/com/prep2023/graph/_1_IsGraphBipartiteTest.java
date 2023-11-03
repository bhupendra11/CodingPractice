package com.prep2023.graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _1_IsGraphBipartiteTest {

    @Test
    public void testIsBipartite() {
        _1_IsGraphBipartite graphBipartite = new _1_IsGraphBipartite();

        // Test case 1: A graph with no edges is bipartite.
        int[][] graph1 = new int[4][0];
        assertTrue(graphBipartite.isBipartite(graph1));

        // Test case 2: A graph with no vertices is bipartite (empty graph).
        int[][] graph2 = new int[0][0];
        assertTrue(graphBipartite.isBipartite(graph2));

        // Test case 3: A simple bipartite graph.
        int[][] graph3 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        assertTrue(graphBipartite.isBipartite(graph3));

        // Test case 4: A simple non-bipartite graph with an odd-length cycle.
        int[][] graph4 = {
                {1, 2, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        assertFalse(graphBipartite.isBipartite(graph4));

        // Test case 5: A bipartite graph with multiple connected components.
        int[][] graph5 = {
                {1},
                {0, 2},
                {1},
                {4},
                {3}
        };
        assertTrue(graphBipartite.isBipartite(graph5));

        // Test case 6: A non-bipartite graph with an odd-length cycle in a connected component.
        int[][] graph6 = {
                {1, 2},
                {0, 2},
                {0, 1}
        };
        assertFalse(graphBipartite.isBipartite(graph6));
    }
}
