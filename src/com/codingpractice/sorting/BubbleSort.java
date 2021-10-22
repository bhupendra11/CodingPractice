package com.codingpractice.sorting;

import java.util.Arrays;

/**
 * Youtube tutorial : https://www.youtube.com/watch?v=Jdtq5uKz-w4&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=3
 *
 * In bubble sort the array is divided into two halfs, one will be sorted (right) and ither will be unsorted(left)
 *
 * With every pass the highest element in the unsorted half will bubble up to the end of unsorted half i.e beginning of sorted half.
 * So the elements will start getting their sorted positions with each pass
 *
 * Eg.
 * 2,4,1,5,3,7
 * After first pass
 * 2,4,1,5,3,7
 * After second pass
 * 2,1,4,3,5,7
 *
 * Time complexity : O(n^2)
 *
 * We can improve this algorithm, check video for improvement in best case
 */
public class BubbleSort {
    public static void main(String[] args) {
        int input[] = {2,4,1,5,3,7};
        System.out.println("Input list " + Arrays.toString(input));
        int putput[] = bubbleSort(input);
        System.out.println("Sorted list "+Arrays.toString(putput));
    }

    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++) {   //only do n-2 passes, else in  last pass we will get out of bounds arrar due to accessing arr[j+1]
                                        // since with every pass, the sorted part will increase, we can change the second loop to only pass unsorted i.e. n-j-1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }


        return arr;
    }
}
