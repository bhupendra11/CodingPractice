package com.prep2023.trees.segmenttree;

/**
 * Author: Bhupendra Shekhawat
 * Date: 31/10/23
 * Topic: com.prep2023.trees.segmenttree
 * Question : <a href="https://leetcode.com/problems/range-sum-query-mutable/">307. Range Sum Query - Mutable</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class RangeSumMutable {

    int segTree[];
    int nums[];
    int stIndex;

    public RangeSumMutable(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        System.out.println("n = "+n );
        segTree = new int[4*n+1];
        this.stIndex = 1;

        int start =0;
        int end = n-1;

        buildSegTree(stIndex, start, end);
    }

    private void buildSegTree(int stIndex, int start, int end){
        if(start > end)return;
        if(start == end){ //leafNode
            segTree[stIndex] = nums[start];
            return;
        }

        int mid = start + (end-start)/2;
        buildSegTree(2*stIndex, start, mid);
        buildSegTree(2*stIndex+1, mid+1, end);

        segTree[stIndex] = segTree[2*stIndex]+ segTree[2*stIndex+1];
    }

    public void update(int index, int val) {
        updateNode(index, val,0,nums.length-1, this.stIndex);
    }

    private void updateNode(int index, int newValue, int start, int end, int stIndex){
        if(start > index || end <index)return;
        if(start == end){ //total overlap
            segTree[stIndex] = newValue;
            return;
        }

        int mid = start + (end - start)/2;
        updateNode(index, newValue, start, mid, 2*stIndex);
        updateNode(index, newValue, mid+1, end, 2*stIndex+1);

        segTree[stIndex] = segTree[2*stIndex] + segTree[2*stIndex+1];
    }

    public int sumRange(int left, int right) {
        return sumRange(this.stIndex,0, nums.length-1, left, right);
    }

    private int sumRange(int stIndex,int start, int end, int qs, int qe){
        // no overlap
        if(qs> end || qe < start)return 0;

        //total overlap
        if(qs <= start && qe >= end){
            return segTree[stIndex];
        }

        int mid = start + (end -start) /2;
        int lSum = sumRange(2*stIndex, start, mid,qs,qe);
        int rSum = sumRange(2*stIndex +1 , mid+1, end, qs, qe);
        return lSum+ rSum;

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
