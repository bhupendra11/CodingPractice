package com.codingpractice.sorting;

import java.util.Arrays;

/**
 * MyCodeSchool tutorial : https://www.youtube.com/watch?v=GUDLRan2DWM&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=2
 * The algorithms states for every iteration find the minimum element in the array and swap it with the current unsorted start index.
 * Restart the ieration, this time with index+1 (Since element at index is already sorted.
 *
 * Worst case time complexity = O(n^2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int array[] = {7,3,9,2,6,4,1};
        System.out.println("Input list " +Arrays.toString(array));
        int sorted[] = selectionSort(array);
        System.out.println("Sorted list "+Arrays.toString(sorted));
    }

    private static int[] selectionSort(int[] arr) {

        for(int i=0;i<arr.length-1;i++){   //only loop till second last element, last will already be sorted , n-2 passes
            int iMin = i;  // iTh position, items from i to n-1 are candidates

            for(int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[iMin]){
                    iMin = j;    //update index of minimum element
                }
            }

            //swap
            int temp = arr[i];
            arr[i] = arr[iMin];
            arr[iMin] = temp;

        }
        return arr;
    }

}

