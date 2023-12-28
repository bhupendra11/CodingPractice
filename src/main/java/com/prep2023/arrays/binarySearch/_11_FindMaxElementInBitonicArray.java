package com.prep2023.arrays.binarySearch;

/**
 * Author: Bhupendra Shekhawat
 * Date: 28/12/23
 * Topic: com.prep2023.arrays.binarySearch
 * Question : <a href="https://www.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _11_FindMaxElementInBitonicArray {

    int findMaximum(int[] arr, int n) {
        // code here

        int low =0;
        int high = n-1;


        while(low<=high){
            int mid = low +(high -low)/2;

            if(mid -1 >=0 && arr[mid-1] > arr[mid]){
                high = mid-1;
            }
            else if(mid+1 <n && arr[mid+1]> arr[mid]){
                low = mid+1;
            }
            else return arr[mid];
        }
        return -1;

    }
}
