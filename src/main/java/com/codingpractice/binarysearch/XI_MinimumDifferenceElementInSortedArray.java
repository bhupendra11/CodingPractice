package com.codingpractice.binarysearch;

/**
 * Find Closet element in array
 *
 * https://www.youtube.com/watch?v=3RhGdmoF_ac&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=15
 * https://practice.geeksforgeeks.org/problems/find-the-closest-number5513/1/
 *
 */
public class XI_MinimumDifferenceElementInSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 7};
        System.out.println(findClosest(arr,4));

        arr = new int[]{1, 2, 3, 5, 6, 8, 9};
        System.out.println(findClosest(arr,4));
    }

    public static int findClosest(int arr[], int target)
    {
        // Complete the function
        int n = arr.length;
        int floor = findFloor(arr,0,n-1,target);
        int ceil = findCeil(arr,0,n-1,target);

        int first = Math.abs(floor-target);
        int second = Math.abs(ceil-target);

        if(first==second)return ceil;
        else return (first < second) ? floor : ceil;
    }

    private static int findFloor(int arr[], int low, int high, int target){
        int res=0;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=target){
                res=mid;
                low=mid+1;
            }
            else{
                high =mid-1;
            }
        }
        return arr[res];
    }

    private static int findCeil(int arr[], int low, int high, int target){
        int res=0;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=target){
                res=mid;
                high=mid-1;
            }
            else{
                low =mid+1;
            }
        }
        return arr[res];
    }


}
