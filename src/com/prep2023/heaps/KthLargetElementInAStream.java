package com.prep2023.heaps;

import java.util.PriorityQueue;

/**
 * Author: Bhupendra Shekhawat
 * Date: 21/10/23
 * Topic: com.prep2023.heaps
 * Question Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * YouTube Link:
 *
 * Problem:
 * 703. Kth Largest Element in a Stream

 * Easy
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Implement KthLargest class:
 *
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 *
 *
 * Example 1:
 *
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 *
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */

public class KthLargetElementInAStream {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargetElementInAStream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k =k;
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>k){
            minHeap.remove();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        // Create a KthLargest instance
        KthLargetElementInAStream kthLargest = new KthLargetElementInAStream(k, nums);

        // Add values and print kth largest at each step
        int[] valuesToAdd = {3, 5, 10, 9, 4};

        for (int val : valuesToAdd) {
            int kthLargestValue = kthLargest.add(val);
            System.out.println("Added " + val + ", Current Kth Largest: " + kthLargestValue);
        }
    }
}
