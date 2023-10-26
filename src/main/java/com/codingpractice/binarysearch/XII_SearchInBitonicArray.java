package com.codingpractice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class XII_SearchInBitonicArray {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 9, 10, 20, 17, 5, 1));
        System.out.println(solve(list,20));
        list = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10, 3, 2, 1));
        System.out.println(solve(list,30));

    }
    private static int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int low =0;
        int high = n-1;

        int pivot =0;

        while(low <= high){
            int mid = low +(high-low)/2;

            if(mid>0 && mid <n-1 && A.get(mid) > A.get(mid-1) && A.get(mid) > A.get(mid+1)){
                pivot = mid;
                break;
            }
            else if(mid<n-1 && A.get(mid) < A.get(mid+1) ){
                low = mid+1;
            }
            else{
                high =mid-1;
            }
        }

        int bs1 = binarySearch(A,0,pivot,B);
        if(bs1 != -1)return bs1;

        return binarySearchDes(A,pivot,n-1,B);


    }


    private static int binarySearch(ArrayList<Integer> A,int low, int high, int target){

        while(low<=high){
            int mid = low + (high-low)/2;

            if(target == A.get(mid)){
                return mid;
            }
            else if(target < A.get(mid)){
                high =mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    private static int binarySearchDes(ArrayList<Integer> A,int low, int high, int target){

        while(low<=high){
            int mid = low + (high-low)/2;

            if(target == A.get(mid)){
                return mid;
            }
            else if(target < A.get(mid)){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
