package com.bhupendra.prep2023.arrays;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class _4_MergeIntervalsTest {

    @Test
    public void testEmptyIntervals() {
        int[][] intervals = {};
        int[][] expected = {};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }

    @Test
    public void testNoOverlap() {
        int[][] intervals = {{1, 3}, {4, 6}, {7, 9}};
        int[][] expected = {{1, 3}, {4, 6}, {7, 9}};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }

    @Test
    public void testOverlappingIntervals() {
        int[][] intervals = {{1, 3}, {2, 6}, {4, 8}};
        int[][] expected = {{1, 8}};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }

    @Test
    public void testOverlappingIntervalsMultipleMerges() {
        int[][] intervals = {{1, 3}, {2, 6}, {4, 8}, {10, 12}, {11, 14}};
        int[][] expected = {{1, 8}, {10, 14}};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }

    @Test
    public void testOverlappingIntervalsWithSameEndpoints() {
        int[][] intervals = {{1, 3}, {3, 6}, {6, 9}};
        int[][] expected = {{1, 9}};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }

    @Test
    public void testOverlappingIntervalsWithNegativeNumbers() {
        int[][] intervals = {{-3, -1}, {-2, 2}, {1, 5}, {4, 6}};
        int[][] expected = {{-3, 6}};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }

    @Test
    public void testSingleInterval() {
        int[][] intervals = {{1, 5}};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }

    @Test
    public void testDuplicateIntervals() {
        int[][] intervals = {{2, 4}, {2, 4}, {2, 4}};
        int[][] expected = {{2, 4}};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }

    @Test
    public void testMixedIntervals() {
        int[][] intervals = {{1, 3}, {2, 6}, {7, 9}, {10, 12}, {15, 18}};
        int[][] expected = {{1, 6}, {7, 9}, {10, 12}, {15, 18}};
        assertArrayEquals(expected, new _4_MergeIntervals().merge(intervals));
    }
}
