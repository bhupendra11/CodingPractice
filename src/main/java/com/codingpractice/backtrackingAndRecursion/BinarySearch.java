package com.codingpractice.backtrackingAndRecursion;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,9,11,34,89};
        int target = 9;
        System.out.println(binarySearch(arr,target));

        arr = new int[]{22, 45, 56, 67, 89, 110, 210,333};
        target = 333;
        System.out.println(binarySearch(arr,target));
    }

    private static  int binarySearch(int[] arr, int target) {
        return helper(arr,target,0,arr.length-1);
    }

    private static int helper(int[] arr, int target, int low, int high){
        if(low>high)return -1;
        int mid = low +(high-low)/2;
        if(arr[mid]==target)return mid;
        else if(arr[mid]<target)return helper(arr,target,mid+1,high);
        else return helper(arr,target,low,mid-1);
    }
}
