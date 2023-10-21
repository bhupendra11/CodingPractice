package com.prep2023.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Author: Bhupendra Shekhawat
 * Date: 21/10/23
 * Topic: com.prep2023.heaps
 * Question Link: https://leetcode.com/problems/top-k-frequent-elements/description/
 * YouTube Link: 
 * Problem: 347. Top K Frequent Elements
 *
 Solution given here is O(nlogk) ass expected in follow up

 Medium

 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]


 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 k is in the range [1, the number of unique elements in the array].
 It is guaranteed that the answer is unique.


 Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        //create a minHeap
        PriorityQueue<Node> heap = new PriorityQueue<Node>((x, y) -> x.count - y.count);

        //O(nlogk)
        for(int i : map.keySet()){
            heap.add(new Node(i, map.get(i)));
            if(heap.size() > k){
                heap.remove();
            }
        }

        //heap size is k
        int[] result = new int[k];

        for(int i=k-1 ;i>=0 ;i--){
            result[i] = heap.remove().num;
        }
        return result;
    }

    class Node{
        int num;
        int count;

        Node(int num, int count){
            this.num = num;
            this.count =count;
        }
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        // Sample input array and k value
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Call the topKFrequent method
        int[] result = solution.topKFrequent(nums, k);

        // Print the result
        System.out.println("Top " + k + " Frequent Elements: " + Arrays.toString(result));
    }
}