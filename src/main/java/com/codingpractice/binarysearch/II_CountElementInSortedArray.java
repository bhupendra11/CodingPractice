package com.codingpractice.binarysearch;

/**
 * https://www.youtube.com/watch?v=Ru_HhBFV3Xo&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=6
 */
public class II_CountElementInSortedArray {

    public static void main(String[] args) {

        int arr[] = {2,4,10,10,10,18,20};
        System.out.println(findCount(arr,10));

        arr = new int[] {2,4,10,10,10,18,20};
        System.out.println(findCount(arr,11));
    }

    private static int findCount(int[] arr, int target){
        int first = bsFirst(arr,0,arr.length-1,target);
        int last = bsLast(arr,0,arr.length-1,target);

        if(first==-1){return 0;}

        return last-first+1;
    }

    private static int bsFirst(int[] arr, int low, int high, int target){
        int first =-1;
        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid]==target){
                first = mid;
                high =mid-1;
            }
            else if(arr[mid] > target){
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return first;
    }

    private static int bsLast(int[] arr, int low, int high, int target){
        int last =-1;
        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid]==target){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] > target){
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return last;

    }

}
