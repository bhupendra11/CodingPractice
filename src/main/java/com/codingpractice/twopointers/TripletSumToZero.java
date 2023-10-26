package com.codingpractice.twopointers;

import java.util.*;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Example 1:
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * Example 2:
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {
    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<arr.length-2; i++){
            if(i>0 && arr[i] ==arr[i-1])continue;   //skip duplicate triplets
            find2Sum(arr,i+1,-arr[i],result);
        }
        return result;
    }

    private static void find2Sum(int[] arr, int left, int target,List<List<Integer>> triplets){
        int right = arr.length -1;


        while(left<right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == target){
                triplets.add(Arrays.asList(-target,arr[left],arr[right]));
                left++;
                right--;

                while(left<right && arr[left]==arr[left-1]){//skip duplicate triplets
                    left++;
                }
                while(left<right && arr[right]==arr[right+1]){//skip duplicate triplets
                    right--;
                }
            }
            else if(currentSum<target){
                left++;
            }
            else {
                right--;
            }

        }
    }
}
