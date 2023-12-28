package com.prep2023.arrays.binarySearch;

import java.util.Arrays;

public class _4_FindTargetRange {

    private static int findFloor(int arr[], int k){
        int low =0;
        int high = arr.length -1;
        int res =0;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] >= k ){
                if(arr[mid] ==k)res = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }return res;
    }

    private static int findCeil(int arr[], int k){
        int low =0;
        int high = arr.length -1;
        int res =0;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] <= k ) {
                if(arr[mid] == k )res = mid;
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,5,6,7,8};
        int low = (findFloor(arr,5));
        int high = (findCeil(arr,5));
        int[] range ={low,high};
        System.out.println("Range = "+ Arrays.toString(range));



    }
}
