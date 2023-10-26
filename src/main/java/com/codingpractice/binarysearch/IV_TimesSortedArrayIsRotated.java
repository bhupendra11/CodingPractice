package com.codingpractice.binarysearch;

/**
 * Tut: https://www.youtube.com/watch?v=4WmTRFZilj8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=7
 *
 *
 * https://practice.geeksforgeeks.org/problems/rotation4723/1/
 */
public class IV_TimesSortedArrayIsRotated {
    public static void main(String[] args) {

        int arr[] = {66, 72, 79, 86, 95, 104, 106, 110, 119, 123, 124, 129, 132, 136, 137, 142, 150, 2, 12, 14, 17, 26, 30, 36, 38, 46, 52, 60};
        int n = arr.length;

        System.out.println(findKRotation(arr,n));

    }

    private static int findKRotation(int arr[], int n) {
        // code here
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int prev = (n+mid-1)%n;
            int next = (mid+1)%n;
            System.out.println("arr[low] = "+arr[low]+" arr[high] = "+arr[high]+" mid = "+mid+ "  arr[mid] = "+arr[mid]);

            //check if array is sorted
            if(arr[low]<=arr[high])return low;

            if(arr[mid]<=arr[prev] && arr[mid] <=arr[next]){
                return mid;   //index of lowest element gives the count of rotations
            }
            if(arr[low] <= arr[mid]){
                low= mid+1;
            }
            else if(arr[mid] <= arr[high]){
                high =mid-1;
            }
        }
        return 0;

    }
}
