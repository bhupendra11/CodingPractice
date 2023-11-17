package com.prep2023.arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 17/11/23
 * Topic: com.prep2023.arrays
 * Question : <a href="https://leetcode.com/problems/container-with-most-water/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _7_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n= height.length;

        int i = 0;
        int j = n-1;

        int max =0;
        while(i<j){
            int cur = Math.min(height[i],height[j]) * (j-i);
            max = Math.max(max,cur);

            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;

    }
}
