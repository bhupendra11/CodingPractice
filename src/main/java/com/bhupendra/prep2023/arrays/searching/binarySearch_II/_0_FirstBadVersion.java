package com.bhupendra.prep2023.arrays.searching.binarySearch_II;

/**
 * Author: Bhupendra Shekhawat
 * Date: 08/11/23
 * Topic: com.prep2023.arrays.searching.binarySearch_II
 * Question : <a href="https://leetcode.com/problems/first-bad-version/">278. First Bad Version</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _0_FirstBadVersion {

    public int firstBadVersion(int n) {
        int low =1;
        int high = n;

        while(low <high){
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    boolean isBadVersion(int version){
        //implementation provided in leetcode
        // assume this function will return T/F depending on if thios version is good or bad
        return true;
    }
}
