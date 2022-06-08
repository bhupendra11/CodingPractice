package com.codingpractice.binarysearch;

/**
 * https://www.youtube.com/watch?v=5cx0xerA8XY&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=10
 *
 * https://www.geeksforgeeks.org/floor-in-a-sorted-array/
 * https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1/
 *
 * For array  1 2 3 4 8 10 10 12 19
 * Floor of 5 = 4    [Greatest element smaller than 5]
 * Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.
 */
public class VII_FindFloorOfElementInArray {

    public static void main(String[] args) {
        int arr[] = {1,2,8,10,11,12,19};
        System.out.println(findFloor(arr,7,5));

        arr = new int[]{1,2,8,10,11,12,19};
        System.out.println(findFloor(arr,7,0));

        arr= new int[]{66 ,67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130};
        System.out.println(findFloor(arr,65,106));
    }

    private static int findFloor(int arr[], int n, long target)
    {
        int low =0;
        int high = n-1;
        int floor=-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid] <=target){
                floor = Math.max(floor, mid);
                low = mid+1;
            }
            else{
                high =mid-1;
            }
        }
        return floor;
    }
}
