package com.prep2023.arrays.binarySearch;

/**
 * Given an array and a target, find the element with which the different is minimum with target
 */
public class _9_MinDiffElementInSortedArray {

    public static void main(String[] args) {
        int arr[] ={1,3,8,10,12,15};
        int target = 7;

        System.out.println(findMinDiffElementIndex(arr,7)); //2
        System.out.println(findMinDiffElementIndex(arr,12));//4
    }

    private static int findMinDiffElementIndex(int[] arr, int target){
        int low =0;
        int high = arr.length-1;

        while (low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]== target){
                return mid;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        //did not find the target

       if(Math.abs(arr[low]-target) < Math.abs(arr[high]-target)){
           return  low;
       }
       else{
           return high;
       }
    }


}
