package com.prep2023.sorting;

import java.util.Arrays;

public class _6_CountingSort {
    public static void countingSort(int arr[]){
        int n = arr.length;

        //determine range
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for(int i : arr){
            if(i < minVal) minVal = i;
            if(i > maxVal ) maxVal = i;
        }

        int range = maxVal - minVal +1;
        int cf[] = new int[range];

        //calculate freq
        for(int i=0;i<n;i++){
            cf[arr[i] - minVal]++;
        }

        //calculate cumulative freq
        for(int i=1;i<range;i++){
            cf[i] += cf[i-1];
        }

        int res[] = new int[n];
        //go from right to left in array
        for(int j=n-1 ; j>=0 ;j--){
            int index = cf[arr[j] - minVal]-1;
            res[index] = arr[j];
            cf[arr[j] - minVal   ]--;
        }
        //copy sorted array into original arr
        for(int i=0;i<n;i++){
            arr[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,1,4,2,8,5,8,2,4,1,0,7,2,5,9,6,2};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
