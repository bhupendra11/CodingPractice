package com.prep2023.sorting;

import java.util.Arrays;

public class _7_RadixSort {
    public static void radixSort(int arr[]){
        int maxVal = Integer.MIN_VALUE;

        for(int i : arr){
            if(i > maxVal ) maxVal = i;
        }

        int exp =1;
        while(exp <= maxVal ){
            countingSort(arr, exp);
            exp *= 10;
        }
    }

    //for radix sort , we need countSort that can work on each digit i.e. witrh range 10
    private static void countingSort(int arr[], int exp){
        int n = arr.length;
        int range = 10;
        int cf[] = new int[range];

        //calculate freq
        for(int i=0;i<n;i++){
            cf[arr[i] / exp % 10]++;
        }

        //calculate cumulative freq
        for(int i=1;i<range;i++){
            cf[i] += cf[i-1];
        }
        int res[] = new int[n];
        //go from right to left in array
        for(int j=n-1 ; j>=0 ;j--){
            int index = cf[arr[j] / exp % 10]-1;
            res[index] = arr[j];
            cf[arr[j] / exp % 10]--;
        }

        for(int i=0;i<n;i++){
            arr[i] = res[i];
        }
    }
    public static void main(String[] args) {
        int arr[] = {170,45,75,90,802,24,2,66};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
