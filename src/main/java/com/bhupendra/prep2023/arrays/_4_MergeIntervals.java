package com.bhupendra.prep2023.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Bhupendra Shekhawat
 * Date: 07/11/23
 * Topic: com.prep2023.arrays
 * Question : <a href="https://leetcode.com/problems/merge-intervals/description/">56. Merge Intervals</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _4_MergeIntervals {
        public int[][] merge(int[][] intervals) {
            if(intervals.length <=1)return  intervals;
            Arrays.sort(intervals, (x, y)-> x[0]-y[0]);

            List<int[]> list = new ArrayList<>();
            int n = intervals.length;
            list.add(intervals[0]);
            for(int i=1;i<n;i++){
                if(intervals[i][0] <= list.get(list.size()-1)[1]){
                    int[] prev = list.get(list.size()-1);

                    int[] mergedInterval = {
                            Math.min(intervals[i][0], prev[0]) , Math.max(intervals[i][1], prev[1])
                    };

                    list.remove(list.size()-1);
                    list.add(mergedInterval);
                }
                else{
                    list.add(intervals[i]);
                }
            }

            int[][] result = new int[list.size()][2];

            for(int i=0;i<list.size(); i++){
                result[i] = list.get(i);
            }
            return result;
        }

}
