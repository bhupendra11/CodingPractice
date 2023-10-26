package com.prep2023.heaps;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Author: Bhupendra Shekhawat
 * Date: 20/10/23
 * Topic: com.prep2023.heaps
 * Problem:
 * Question Link: https://leetcode.com/problems/sliding-window-maximum/
 * YouTube Link:
 * 
 * LC 239. Sliding Window Maximum - HARD
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */



public class SlidingWindowMax {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length > k ? nums.length+1 -k : 1;
        int[] res = new int[length];
        int resIndex =0;

        //use to only store indexes
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int l=0;
        int r=0;

        while(r<nums.length){
            //remove any smaller element from deque
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]){
                dq.removeLast();
            }
            dq.addLast(r);

            //if element out of window, remove
            if(l > dq.peekFirst()){
                dq.removeFirst();
            }

            //only start adding elements to result once we are oover a window size
            // also only increment i after reaching window size
            if(r+1 >= k){
                res[resIndex] = nums[dq.peekFirst()];
                resIndex++;
                l++;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        // Sample input array and window size
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Calculate maximums using maxSlidingWindow method
        int[] result = maxSlidingWindow(nums, k);

        // Print the result
        System.out.println("Max Sliding Window:");
        System.out.println(Arrays.toString(result));
    }
    
}
