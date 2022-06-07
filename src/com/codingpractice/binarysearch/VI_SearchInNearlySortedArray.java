package com.codingpractice.binarysearch;

/**
 *https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9
 *
 * https://www.geeksforgeeks.org/search-almost-sorted-array/
 *
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 * For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
 * Example :
 *
 *
 * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
 * Output: 2
 * Output is index of 40 in given array
 *
 * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
 * Output: -1
 * -1 is returned to indicate element is not present
 */
public class VI_SearchInNearlySortedArray {
    public static void main(String[] args) {
        int arr[] = {10, 3, 40, 20, 50, 80, 70};
        int target = 40;

        System.out.println(search(arr,target));

        arr =  new int[]{10, 3, 40, 20, 50, 80, 70};
        target= 90;

        System.out.println(search(arr,target));
    }

    private static int search(int[] arr, int target){
        int n = arr.length;
        int low =0;
        int high = n -1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(target==arr[mid]){
                return mid;
            }
            //check the adjacent sides
            if(mid > low && target==arr[mid-1])return mid-1;
            if(mid <high && target == arr[mid+1])return mid+1;

            if(target <= arr[mid]){
                high = mid-2;
            }
            else{
                low =mid+2;
            }
        }
        return -1;

    }
}
