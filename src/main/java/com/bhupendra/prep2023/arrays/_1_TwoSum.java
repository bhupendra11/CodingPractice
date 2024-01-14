package com.bhupendra.prep2023.arrays;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //solution 1
        // sort and then use 2 pointers -> O(nlogn+n) -> O(nlogn)

        //solution2
        // Use a map to store all nums
        // traverse agin to fing complementary

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }

        int res[] = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
            }
        }
        return res;
    }
}