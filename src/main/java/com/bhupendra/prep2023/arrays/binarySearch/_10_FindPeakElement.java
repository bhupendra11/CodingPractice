package com.bhupendra.prep2023.arrays.binarySearch;

public class _10_FindPeakElement {
    public static void main(String[] args) {

        //Given an array, find peak element, the array may / maynot be sorted

        int arr[] = {1,2,3,1};
        int[] arr2 = {1,2,1,3,5,6,4};

        System.out.println(findPeak(arr));
        System.out.println(findPeak(arr2));
    }

    private static int findPeak(int arr[]){
        int n = arr.length;
        int low = 0;
        int high = n -1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(mid -1 >=0 && arr[mid-1] > arr[mid] ){
                high = mid-1;
            }
            else if(mid+1 <n && arr[mid+1] > arr[mid]){
                low = mid+1;
            }
            else return mid;
        }
        return -1;
    }
}
