package com.prep2023.heaps;

import java.util.*;

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

    //Approach 1
    // O(N) using bucket sort
    public int[] topKFrequentKLinear(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int n = nums.length;
        List<Integer>[] buckets = new List[n+1];
        for(int i=0;i<= n;i++){
            buckets[i] = new ArrayList<>();
        }
        for(int key : map.keySet()){
            buckets[map.get(key)].add(key);
        }

        int res[] = new int[k];
        List<Integer> flattened = new ArrayList<>();
        for(int i=buckets.length-1 ;i >=0 ;i--){
            for(int key : buckets[i]){
                flattened.add(key);
            }
        }

        for(int i=0;i<k;i++){
            res[i] = flattened.get(i);
        }
        return res;
    }

    //Approach 1
    // Gives O(nlogk) using heaps
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)-> map.get(x) -map.get(y));
        for(int key: map.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.remove();
            }
        }
        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i] = pq.remove();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        // Sample input array and k value
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Call the topKFrequent method
        //int[] result = solution.topKFrequent(nums, k);

        int[] result = solution.topKFrequentKLinear(nums, k);

        // Print the result
        System.out.println("Top " + k + " Frequent Elements: " + Arrays.toString(result));
    }
}