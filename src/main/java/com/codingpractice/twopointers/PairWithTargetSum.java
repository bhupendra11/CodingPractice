package com.codingpractice.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 *
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }

    //Just works on sorted array
    public static int[] search(int[] arr, int targetSum) {
        int res[] = new int[2];

        int i=0, j= arr.length -1;

        while(i<j){
            if(targetSum == arr[i]+arr[j]){
                res[0]=i;
                res[1]=j;
                return res;
            }
            else if(targetSum < arr[i]+arr[j]){
                j--;
            }
            else {
                i++;
            }
        }
        return res;
    }

    //Using hashmap , works on unsorted array as well
    public static int[] search2(int[] arr, int targetSum){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(targetSum-arr[i])){
                return new int[]{map.get(targetSum-arr[i]),i};
            }
            else{
                map.put(arr[i],i);
            }
        }

        return new int[]{-1,-1};
    }



}
