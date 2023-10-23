package com.prep2023.stackAndQueues.monotonicStack;

public class _4LargetRectangleInHistogramBasic {


    //APPROACH 1 : 2 pointer
    // TC O(n2)
    // SC : O(1)
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                maxArea = Math.max(maxArea, width * minHeight);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        _4LargetRectangleInHistogramBasic solution = new _4LargetRectangleInHistogramBasic();

        // Test Case 1
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int expected1 = 10;
        int actual1 = solution.largestRectangleArea(heights1);

        System.out.println("Test Case 1:");
        System.out.println("Expected: " + expected1);
        System.out.println("Actual: " + actual1);
        System.out.println("Test Status: " + (expected1 == actual1 ? "Pass" : "Fail"));
        System.out.println();

        // Test Case 2
        int[] heights2 = {1, 2, 3, 4, 5};
        int expected2 = 9;
        int actual2 = solution.largestRectangleArea(heights2);

        System.out.println("Test Case 2:");
        System.out.println("Expected: " + expected2);
        System.out.println("Actual: " + actual2);
        System.out.println("Test Status: " + (expected2 == actual2 ? "Pass" : "Fail"));
        System.out.println();

        // Test Case 3
        int[] heights3 = {5, 4, 3, 2, 1};
        int expected3 = 9;
        int actual3 = solution.largestRectangleArea(heights3);

        System.out.println("Test Case 3:");
        System.out.println("Expected: " + expected3);
        System.out.println("Actual: " + actual3);
        System.out.println("Test Status: " + (expected3 == actual3 ? "Pass" : "Fail"));
    }

}
