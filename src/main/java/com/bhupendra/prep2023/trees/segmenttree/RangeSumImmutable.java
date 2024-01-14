package com.bhupendra.prep2023.trees.segmenttree;

public class RangeSumImmutable {
    int prefixSum[];
    public RangeSumImmutable(int[] nums) {
        prefixSum = new int[nums.length];
        int n = nums.length;

        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
    }

    public int sumRange(int left, int right) {
        if(left ==0)return  prefixSum[right];
        return prefixSum[right] - prefixSum[left-1];
    }
}
