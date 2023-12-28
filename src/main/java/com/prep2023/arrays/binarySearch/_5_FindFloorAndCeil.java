package com.prep2023.arrays.binarySearch;

import java.util.Arrays;

public class _5_FindFloorAndCeil {

    private static int findFloor(int[] arr, int k){
        int low =0;
        int high = arr.length -1;
        int res = arr.length-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] <= k ){
                res = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }return res;
    }

    private static int findCeil(int arr[], int k){
        int low =0;
        int high = arr.length -1;
        int res =0;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] >= k ) {
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,5,5,6,9,11,65,99};
        System.out.println("For 5, Floor = "+ findFloor(arr,5)+" ceil "+findCeil(arr,5));
        System.out.println("For 7, Floor = "+ findFloor(arr,7)+" ceil "+findCeil(arr,7));
        System.out.println("For 55, Floor = "+ findFloor(arr,55)+" ceil "+findCeil(arr,55));



    }
}
