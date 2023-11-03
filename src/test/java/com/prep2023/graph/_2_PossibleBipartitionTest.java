package com.prep2023.graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class _2_PossibleBipartitionTest {

    @Test
    public void testPossibleBipartition() {
        _2_PossibleBipartition bipartition = new _2_PossibleBipartition();

        // Test case 1: Invalid bipartition
        int[][] dislikes1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse(bipartition.possibleBipartition(5, dislikes1));

        // Test case 2: Another valid bipartition
        int[][] dislikes2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        assertTrue(bipartition.possibleBipartition(5, dislikes2));

        // Test case 3: Valid bipartition
        int[][] dislikes3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 4}};
        assertTrue(bipartition.possibleBipartition(5, dislikes3));

        // Test case 4: No dislikes, should be considered bipartite
        int[][] dislikes4 = {};
        assertTrue(bipartition.possibleBipartition(5, dislikes4));

        // Test case 5: Single node, should be considered bipartite
        int[][] dislikes5 = {};
        assertTrue(bipartition.possibleBipartition(1, dislikes5));
    }
}
