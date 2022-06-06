package com.codingpractice.binarysearch;

/**
 * https://www.youtube.com/watch?v=zr_AoTxzn0Y&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=5
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
 */
public class FirstAndLastOccurenceOfAnElement {

    public static void main(String[] args) {

        int arr[] = {2,4,10,10,10,18,20};
        int first = bsFirst(arr,0,arr.length-1,10);
        int last = bsLast(arr,0,arr.length-1,10);
        System.out.println(first+" "+last);

        arr = new int[] {2,4,10,10,10,18,20};
        first = bsFirst(arr,0,arr.length-1,11);
        last = bsLast(arr,0,arr.length-1,11);
        System.out.println(first+" "+last);


    }

    private static int bsFirst(int[] arr, int low, int high, int target){
        int first =-1;
        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid]==target){
                first = mid;
                high =mid-1;
            }
            else if(arr[mid] > target){
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return first;
    }

    private static int bsLast(int[] arr, int low, int high, int target){
        int last =-1;
        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid]==target){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] > target){
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return last;

    }
}
