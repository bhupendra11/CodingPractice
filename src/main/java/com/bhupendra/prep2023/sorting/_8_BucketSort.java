package com.bhupendra.prep2023.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Use when the numbers/ elements are distributed evenly
 */
public class _8_BucketSort {

    public static void bucketSort(int arr[]){
        int n = arr.length;
        int bucketLength =10;
        //number of buckets
        int nB = n/10 +1;

        //determine range
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for(int i : arr){
            if(i < minVal) minVal = i;
            if(i > maxVal ) maxVal = i;
        }

        int range = maxVal - minVal +1;

        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0;i<nB;i++){
            buckets.add(new ArrayList<>());
        }

        for(int num : arr){
            // find which bucket
            int bucketIndex = (num - minVal)/nB;
            List<Integer> bucket = buckets.get(bucketIndex);
            insertionSortAddition(bucket,num);
        }

        int i =0;
        for(List<Integer> bucket : buckets){
            for(int num : bucket){
                arr[i] = num;
                i++;
            }
        }
    }

    private static void insertionSortAddition(List<Integer> list, int newNum){
        //add new element at end
        list.add(newNum);
        int j= list.size() -1;
        //move it till smaller element is found like insertion sort
        while(j >0){
            if(list.get(j) < list.get(j-1)){
                //swap
                int temp = list.get(j);
                list.set(j,list.get(j-1));
                list.set(j-1, temp);
                j--;
            }
            else break;
        }
    }
    public static void main(String[] args) {
        int arr[] = {170,45,75,90,802,24,2,66};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}