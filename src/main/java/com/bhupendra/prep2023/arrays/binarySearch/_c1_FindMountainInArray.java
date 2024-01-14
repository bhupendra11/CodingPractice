package com.bhupendra.prep2023.arrays.binarySearch;

/**
 * Author: Bhupendra Shekhawat
 * Date: 28/12/23
 * Topic: com.prep2023.arrays.binarySearch
 * Question : <a href=""></a>
 * YouTube : <a href="">Link to YouTube</a>
 *
 * Intuition
*         Find Peak element, since this is a mountain, only 1 peak element is present.
*         Once you find that, binary search on left side,
*         if not found -> binary search on right side
 *
 *         Approach
 *         Complexity
 *         Time complexity:
 *         O(log N)
 *
 *         Space complexity:
 *         O(1)
 *
 *         Code
 *
 * /

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */


public class _c1_FindMountainInArray {

    interface MountainArray {
        public int get(int index);
        public int length();
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        //given a mountain already i.e. only 1 peak and I need to find the target

        int n = mountainArr.length();
        int low =0;
        int high = n-1;

        // A good approach is find the peak, then do binary search in left,
        //if not found then binary search on right

        int peak = findPeak(low, high,n, mountainArr);
        int leftSearchResult = binarySearch(low,peak,mountainArr, target);

        if(leftSearchResult == -1){
            return binarySearchRev(peak+1,high,mountainArr, target);
        }
        return leftSearchResult;

    }

    private int binarySearch(int low, int high, MountainArray mountainArr, int target){
        while(low <= high){
            int mid = low + (high -low)/2;

            if(target < mountainArr.get(mid)){
                high = mid-1;
            }
            else if(target > mountainArr.get(mid)){
                low = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    private int binarySearchRev(int low,int high, MountainArray mountainArr, int target){
        while(low <= high){
            int mid = low + (high -low)/2;

            if(target < mountainArr.get(mid)){
                low = mid+1;
            }
            else if(target > mountainArr.get(mid)){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }


    private int findPeak(int low, int high, int n, MountainArray mountainArr){
        while(low <= high){
            int mid = low + (high -low)/2;

            if(mid-1 >=0 && mountainArr.get(mid -1) > mountainArr.get(mid)){
                high = mid-1;
            }
            else if(mid+1 <n && mountainArr.get(mid + 1) > mountainArr.get(mid)){
                low = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}