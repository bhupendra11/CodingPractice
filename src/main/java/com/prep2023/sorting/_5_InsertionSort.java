package com.prep2023.sorting;

import java.util.Arrays;

/**
 * Insertion sort can be used in situations where
 * - You are not given all the inputs at the same time
 * - You are getting a stream of inputs and you want the array to be sorted after every new element is added
 *
 * Basically insertion sort takes a new element and just keep swapping with the last element till  it reaches an element
 * smaller than the new element
 *
 * Eg , consider this array where hw every new element is inserted
 * prev    addElement
 * state
 * []  -> [5]
 * [5] -> [5,1  -> swap -> [1,5]
 * [1,5] -> [1,5,4] -> swap -> [1,4,5]
 * [1,4,5] -> [1,4,5,2  -> swap(5,2) -> [1,4,2,5] -> swap(4,2) -> [1,2,4,5]
 *
 */
public class _5_InsertionSort {

    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int j=i;
            while(j >0){
                if(arr[j]< arr[j-1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                }
                else break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,1,4,2,8};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
