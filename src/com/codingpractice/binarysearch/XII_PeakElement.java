package com.codingpractice.binarysearch;

public class XII_PeakElement {

    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        System.out.println(findPeakElement(arr));
        arr = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
    private static  int findPeakElement(int[] nums) {

        int n = nums.length;
        int low =0;
        int high = n-1;
        int ans=0;

        if(n==0 || n==1)return 0;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(mid>0 && mid<n-1 && nums[mid]> nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(mid <n-1 && nums[mid] < nums[mid+1]){
                low=mid+1;
            }
            else if (mid >0 && nums[mid] < nums[mid-1]) {
                high =mid-1;
            }

            //check edge conditions
            if(mid==0){
                if(nums[mid] > nums[mid+1]){
                    return mid;
                }
                else return mid+1;

            }
            if(mid==n-1){
                if(nums[mid] > nums[mid-1]){
                    return mid;
                }
                else return mid-1;
            }
        }
        return 0;
    }

}
