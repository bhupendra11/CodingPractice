package com.bhupendra.prep2023.sorting;

import java.util.Arrays;


public class _4_Quicksort {

    public static void main(String[] args) {
        int arr[] = {5,1,4,2,8,3};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[]){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        //base case - single element
        if(low >= high)return;
        int pivotIndex = partition(arr,low, high);
        quickSort(arr,low,pivotIndex-1);
        quickSort(arr,pivotIndex+1,high);
    }

    private static  int partition(int arr[], int low, int high){
        int i = low -1;
        for(int j = low; j<high;j++){
            if(arr[j]<arr[high]){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr,i, high);
        return i;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
