package com.prep2023.arrays.binarySearch;

public class _2_SearchInSortedRotated {

    public static void main(String[] args) {
        int[] arr1 = {5,6,7,8,1,2,3,4};
        int[] arr2 = {1,2,3,4,5};

        int[] arr3 = {};
        int[] arr4 = {3,4,5,1,2};

        int[] arr5 = {5,6,7,8,0,1,2,3,4};

        System.out.println(searchInRotated(arr1,7));  //2
        System.out.println(searchInRotated(arr2,3)); //2
        System.out.println(searchInRotated(arr3,5)); //-1
        System.out.println(searchInRotated(arr4,1)); //3
        System.out.println(searchInRotated(arr5,8)); //3
    }

    private static int searchInRotated(int[] arr, int k){
        int pivot = findMinIndex(arr);
        int n = arr.length;
        if(n==0)return -1;
        if(k > arr[n-1]){
            return binarySearch(0,pivot-1,arr,k);
        }
        else{
            return binarySearch(pivot,n-1,arr,k);
        }
    }

    private static int binarySearch(int low, int high, int [] arr, int target){

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(target == arr[mid]){
                return mid;
            }
            else if(target < arr[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    private static int findMinIndex(int[] arr){
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high){
            int mid = low + (high-low)/2;
            int prev = (mid-1+n)%n;
            int next = (mid+1)%n;

            if(arr[mid] <= arr[prev] && arr[mid] <=arr[next]){
                return mid;
            }
            else if(arr[0] <= arr[mid]){ //left side sorted
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
