package com.prep2023.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);   // O(nlogn)   Sort toget help in 2 sum
        if (nums.length < 3) return list;

        //the idea is to loop through all elemnts and for every element i ,
        //perform the 2sum for (i+1)th to (n-1)th element
        for (int i = 0; i < n - 2; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //skip duplicate

                List<int[]> twoSumRes = twoSum(nums, i + 1, -1 * nums[i]);

                for (int arr[] : twoSumRes) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(arr[0]);
                    cur.add(arr[1]);
                    list.add(cur);
                }
            }

        }
        return list;
    }

    private List<int[]> twoSum(int[] nums, int start, int target) {
        //array is sorted
        int low = start;
        int high = nums.length - 1;
        List<int[]> result = new ArrayList<>();
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                int res[] = {nums[low], nums[high]};
                //skip dupes
                while (low + 1 < high && nums[low + 1] == nums[low]) low++;
                while (high - 1 > low && nums[high - 1] == nums[high]) high--;

                low++;
                high--;
                result.add(res);
            } else if (nums[low] + nums[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }
}