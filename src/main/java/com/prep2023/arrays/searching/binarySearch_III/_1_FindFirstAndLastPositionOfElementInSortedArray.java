package com.prep2023.arrays.searching.binarySearch_III;

public class _1_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length ==0)return new int[]{-1,-1};

        int leftBound = binarySearch(nums, target, true);
        if(leftBound == -1)return new int[]{-1,-1};

        int rightBound = binarySearch(nums, target, false);

        return new int[] {leftBound, rightBound};
    }

    private int binarySearch(int[] nums, int target, boolean isLeft){
        int n = nums.length;
        if(n==0)return -1;
        int low =0;
        int high = n-1;
        int res = -1;
        while(low <= high){

            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                res = mid;
                if(isLeft){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else {
                high = mid-1;
            }

        }
        return res;
    }
}
