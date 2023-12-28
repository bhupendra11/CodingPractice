package com.prep2023.arrays.binarySearch;

/**
 * Author: Bhupendra Shekhawat
 * Date: 28/12/23
 * Topic: com.prep2023.arrays.binarySearch
 * Question : <a href="https://www.interviewbit.com/problems/search-in-bitonic-array/></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _12_SearchInBitonicArray {
    public int solve(int[] A, int B) {
        // bitonic is first increasing and then decreasing

        int low =0;
        int n = A.length;
        int high = n-1;

        int peak = findPeak(A,low,high,n);
        //System.out.println("Peak = "+peak);
        int leftResult = binarySearch(A,low,peak,B,true);

        if(leftResult == -1){
            return binarySearch(A,peak+1,high,B,false);
        }
        return leftResult;

    }

    private int findPeak(int arr[], int low, int high, int n){
        while(low <= high){
            int mid = low + (high -low)/2;

            if( mid -1 >=0 && arr[mid-1] > arr[mid]){
                high = mid-1;
            }
            else if( mid +1 <n && arr[mid+1] > arr[mid]){
                low = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    private int binarySearch(int arr[], int low, int high, int target,boolean isAscending){

        while(low <= high){
            int mid = low + (high-low)/2;

            if(target == arr[mid]){
                return mid;
            }
            else if(target < arr[mid]){
                if(isAscending) high = mid -1;
                else  low = mid+1;
            }
            else{
                if(isAscending) low = mid+1;
                else  high = mid -1;
            }
        }
        return -1;
    }

}
