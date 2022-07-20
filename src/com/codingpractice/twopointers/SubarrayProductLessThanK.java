package com.codingpractice.twopointers;

import java.util.*;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        int arr1[] ={2, 5, 3, 10};
        int arr2[] = {8, 2, 6, 5};

        System.out.println(findSubarrays(arr1,30));
       // System.out.println(findSubarrays(arr2,50));
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        // TODO: Write your code here
        int i=0, j=0;
        int n = arr.length;

        int product =arr[0];




        while(j<n && i<=j){

            System.out.println("Prod = "+product +" i = "+i+" j = "+j+" result = "+subarrays);

            if(product<target){
                List<Integer> current = getIntList(Arrays.copyOfRange(arr,i,j+1));
                subarrays.add(current);
                j++;
                if(j<n){
                    product *= arr[j];
                    subarrays.add(new ArrayList<>(Arrays.asList(arr[j])));
                }
            }
            else{ //product >= target
                product /= arr[i];    //remove ith elem from product
                i++;
            }

        }

        return subarrays;
    }

    private static List<Integer> getIntList(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i: arr){
            list.add(i);
        }
        return list;
    }
}