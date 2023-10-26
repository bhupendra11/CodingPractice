package com.codingpractice.binarysearch;

public class X_FirstOneIninfiniteBinarySortedArray {
    public static void main(String[] args) {
        int arr[] ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        System.out.println(findFirstOne(arr));
    }

    private  static int findFirstOne(int[] arr){
        int start =0;
        int end =1;

        while(arr[end] !=1){
            start = end;
            end*=2;
        }

        return binarySearch(arr, start,end);

    }

    private static int binarySearch(int[] arr, int low, int high){
        int result =-1;
        while(low<=high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] ==1){
                result =mid;
                high =mid-1;
            }
            else{
                low =mid+1;
            }
        }
        return result;

    }
}
