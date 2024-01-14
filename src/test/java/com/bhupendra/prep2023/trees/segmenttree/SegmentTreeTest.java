package com.bhupendra.prep2023.trees.segmenttree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class SegmentTreeTest {

    private SegmentTree segmentTree;

    @BeforeEach
    public void setUp() {
        int[] arr = {1, 3, 2, -2, 4, 5};
        segmentTree = new SegmentTree(arr.length);
        segmentTree.buildSegmentTree(1, arr, 0, arr.length - 1);
    }

    @Test
    public void testQuery() {
        // Test queries
        int query1 = segmentTree.query(2, 4, 1, 0, segmentTree.segmentTree.length / 4 - 1);
        int query2 = segmentTree.query(1, 4, 1, 0, segmentTree.segmentTree.length / 4 - 1);
        int query3 = segmentTree.query(3, 3, 1, 0, segmentTree.segmentTree.length / 4 - 1);

        assertEquals(4, query1);
        assertEquals(7, query2);
        assertEquals(-2, query3);
    }

    @Test
    public void testUpdate() {
        // Test updates
        segmentTree.updateNode(1, 0, segmentTree.segmentTree.length / 4 - 1, 2, 100);

        // Verify the updated segment tree
        int query1 = segmentTree.query(2, 4, 1, 0, segmentTree.segmentTree.length / 4 - 1);
        int query2 = segmentTree.query(1, 4, 1, 0, segmentTree.segmentTree.length / 4 - 1);

        assertEquals(102, query1);
        assertEquals(105, query2);
    }
}
