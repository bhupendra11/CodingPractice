package com.prep2023.graph.apsp_floyd_warshall;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class CityWithSmallestNumberOfNeighborsAtThreasholdTest {

    @Test
    public void testFindTheCity() {
        CityWithSmallestNumberOfNeighborsAtThreashold solution = new CityWithSmallestNumberOfNeighborsAtThreashold();

        // Test case 1
        int n1 = 4;
        int[][] edges1 = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int threshold1 = 4;
        int expected1 = 3;
        int result1 = solution.findTheCity(n1, edges1, threshold1);
        assertEquals(expected1, result1);

        // Test case 2
        int n2 = 5;
        int[][] edges2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int distanceThreshold2 = 2;
        int expected2 = 0;
        int result2 = solution.findTheCity(n2, edges2, distanceThreshold2);
        assertEquals(expected2, result2);


        // Add more test cases as needed
    }
}
