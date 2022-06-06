package com.codingpractice.binarysearch;

/**
 * Tutorial : https://www.youtube.com/watch?v=QNGL_t_o_QA&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=2
 */

public class BinarySearch {
    public static void main(String[] args) {

        int arr[] = {1,2,9,11,34,89};
        int target = 9;
        System.out.println(binarySearch(arr,target));

        arr = new int[]{22, 45, 56, 67, 89, 110, 210,333};
        target = 333;
        System.out.println(binarySearch(arr,target));

    }

    private static int binarySearch(int[] arr, int target){
        int low =0;
        int high = arr.length-1;

        while(low<=high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] ==target){
                return mid;
            }
            else if(arr[mid] > target){
                high = mid-1;
            }
            else{
                low =mid+1;
            }
        }
        return -1;

    }
}
