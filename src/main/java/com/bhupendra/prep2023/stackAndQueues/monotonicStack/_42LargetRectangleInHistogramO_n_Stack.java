package com.bhupendra.prep2023.stackAndQueues.monotonicStack;

import java.util.Stack;

public class _42LargetRectangleInHistogramO_n_Stack {

    //Approach 2 : Using stack
    // For every height, we want to see how much I can extend the area to the left
    // and to the right
    // i.e  then I can simply do
    // heights[i] * (maxRight - maxLeft -1)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //make a monotonic non -decreasing stack
        Stack<Integer> stack = new Stack<>();
        int nse[] = new int[n];  //create next smallest element array
        int pse[] = new int[n];  // create prev smaller element array

        //create nse - traverse from back
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = n;  // use an index which is +1 the heights array
            } else {
                nse[i] = stack.peek();
            }
            stack.push(i);

        }

        //print nse
        for (int i = 0; i < n; i++) {
            System.out.print(nse[i] + " ");
        }

        stack.clear();

        //create pse
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;  // use -1 as previous index if none available
            } else {
                pse[i] = stack.peek();
            }
            stack.push(i);

        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        _42LargetRectangleInHistogramO_n_Stack solution = new _42LargetRectangleInHistogramO_n_Stack();

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

