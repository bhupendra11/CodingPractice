package com.prep2023.arrays.binarySearch;

/**
 * Author: Bhupendra Shekhawat
 * Date: 27/12/23
 * Topic: com.prep2023.arrays.binarySearch
 * Question : <a href="https://www.geeksforgeeks.org/search-almost-sorted-array/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _3_FindInNearlySortedArray {

    private static int binarySearchNearlySorted(int arr[], int k ){
        int low = 0;
        int n= arr.length;
        int high = n-1;

        while(low <= high){
            int mid = low +(high - low)/2;

            if(arr[mid] == k){
                return mid;
            }
            if(mid -1 >=0 && arr[mid-1] ==k){
                return mid-1;
            }
            if(mid+1 < n && arr[mid+1] ==k){
                return mid+1;
            }

            if(arr[mid] > k){
                low = mid-2;
            }
            if(arr[mid] <k){
                high = mid+2;
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = { 3, 2, 10, 4, 40 };
        int n = arr.length;
        int x = 4;
        int result = binarySearchNearlySorted(arr, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println(
                    "Element is present at index " + result);
    }
}
