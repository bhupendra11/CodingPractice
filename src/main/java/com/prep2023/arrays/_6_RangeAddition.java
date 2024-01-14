package com.prep2023.arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 08/11/23
 * Topic: com.prep2023.arrays
 * Question : <a href="https://leetcode.com/problems/range-addition/description/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _6_RangeAddition {

    /**
     *
     Option 1: just do a linear iteration for each query and do uopdate for the segment
     Worst case time O(updates*N) -> n is length

     But the thing to note here is , when a range is updated
     their is no relative change between the elements of the range, as all the elements of the range
     are updated by the same factor

     If i and j are boundaries for the range, the only change we see is between (i-1, i)
     and (j, j+1)

     We just need to retain this info to finally construct the array after all the updates
     */
    public int[] getModifiedArray(int length, int[][] updates) {

        int gradient[] = new int[length];

        // no need to calculate gradient as the starting elements in array are 0s

        for(int[] query : updates){
            int start = query[0];
            int end = query[1];
            int val = query[2];

            gradient[start] = gradient[start]+ val;
            if(end+1 < length){
                gradient[end+1] = gradient[end+1] - val;
            }
        }
        //performa cumulative sum
        for(int i=1;i<length;i++){
            gradient[i] += gradient[i-1];
        }
        return gradient;
    }
}
