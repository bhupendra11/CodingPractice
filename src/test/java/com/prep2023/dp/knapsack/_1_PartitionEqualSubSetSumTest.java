package com.prep2023.dp.knapsack;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _1_PartitionEqualSubSetSumTest {
        @Test
        public void testCanPartition() {
            _1_PartitionEqualSubSetSum partitionEqualSubSetSum = new _1_PartitionEqualSubSetSum();

            // Test Case 1
            int[] nums1 = {1, 5, 11, 5};
            assertTrue(partitionEqualSubSetSum.canPartition(nums1));

            // Test Case 2
            int[] nums2 = {1, 2, 3, 5};
            assertFalse(partitionEqualSubSetSum.canPartition(nums2));

            // Test Case 3
            int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
            assertTrue(partitionEqualSubSetSum.canPartition(nums3));

            // Test Case 4
            int[] nums4 = {2, 2, 3, 5};
            assertFalse(partitionEqualSubSetSum.canPartition(nums4));

            // Test Case 5
            int[] nums5 = {1, 2, 3, 4, 5, 6};
            assertFalse(partitionEqualSubSetSum.canPartition(nums5));
        }
    }
