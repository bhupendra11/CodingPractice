package com.prep2023.arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 22/11/23
 * Topic: com.prep2023.arrays
 * Question : <a href="https://leetcode.com/problems/trapping-rain-water/"> Trapping rain water</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _8_TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        int max =height[0];
        leftMax[0] = max;
        for(int i=1;i<n;i++){
            if(height[i] > max){
                max = height[i];
            }
            if(max > height[i]){
                leftMax[i] = max;
            }

        }

        max =height[n-1];
        for(int i=n-2;i>=0;i--){
            if(height[i] > max){
                max = height[i];
            }
            if(max > height[i])
                rightMax[i] = max;
        }

        int res =0;
        for(int i=0;i<n;i++){
            if(leftMax[i] == 0 || rightMax[i] ==0){
                continue;
            }
            int min = Math.min(leftMax[i], rightMax[i]);
            if( min -height[i] >0 ){
                res += min -height[i];
            }
        }
        return res;
    }
}
