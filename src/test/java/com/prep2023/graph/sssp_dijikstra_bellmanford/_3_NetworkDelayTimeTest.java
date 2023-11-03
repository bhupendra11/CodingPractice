package com.prep2023.graph.sssp_dijikstra_bellmanford;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _3_NetworkDelayTimeTest {

    @Test
    public void testNetworkDelayTime() {
        _3_NetworkDelayTime networkDelayTime = new _3_NetworkDelayTime();

        // Test case 1
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n1 = 4;
        int k1 = 2;
        int result1 = networkDelayTime.networkDelayTime(times1, n1, k1);
        assertEquals(2, result1);

        // Test case 2
        int[][] times2 = {{1, 2, 1}};
        int n2 = 2;
        int k2 = 2;
        int result2 = networkDelayTime.networkDelayTime(times2, n2, k2);
        assertEquals(-1, result2);

        // Test case 3
        int[][] times3 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
        int n3 = 3;
        int k3 = 1;
        int result3 = networkDelayTime.networkDelayTime(times3, n3, k3);
        assertEquals(3, result3);
    }
}