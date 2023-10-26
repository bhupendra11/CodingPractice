package com.codingpractice.binarysearch;

public class IX_FindElementInInfiniteSortedArray {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};

        System.out.println(searchInfiniteArray(arr,9));
    }

    private  static int searchInfiniteArray(int[] arr, int target){
        int start =0;
        int end =1;

        while(target > arr[end]){
            start = end;
            end*=2;
        }

        return binarySearch(arr, start,end,target);

    }

    private static int binarySearch(int[] arr, int low, int high, int target){

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
