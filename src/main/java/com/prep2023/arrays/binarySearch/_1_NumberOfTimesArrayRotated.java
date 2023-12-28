package com.prep2023.arrays.binarySearch;

/**
 * Author: Bhupendra Shekhawat
 * Date: 27/12/23
 * Topic: com.prep2023.arrays.binarySearch
 * Question : <a href="https://www.geeksforgeeks.org/problems/rotation4723/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_NumberOfTimesArrayRotated {

    // [1,2,3,4,5,6,7,8]

    //rotate [5,6,7,8,1,2,3,4]

    private static int countRotations(int arr[]){
        //find min
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        int ans = 0;
        while(low <= high){
            mid = low + (high-low)/2;

            if(arr[mid] > arr[arr.length-1]){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {5,6,7,8,1,2,3,4};
        int[] arr2 = {1,2,3,4,5};

        int[] arr3 = {};
        int[] arr4 = {5,4,3,2,1};

        int[] arr5 = {5,6,7,8,0,1,2,3,4};

        System.out.println(countRotations(arr1));
        System.out.println(countRotations(arr2));
        System.out.println(countRotations(arr3));
        System.out.println(countRotations(arr4));
        System.out.println(countRotations(arr5));
    }
}
