package com.prep2023.greedy;

public class _2_JumpGame_II {
        public int jump(int[] nums) {
            int n= nums.length;

            int curMax =0;
            int curEnd =0;
            int jump =0;

            for(int i=0;i<n-1;i++){
                // find the next max
                curMax = Math.max(curMax, i+nums[i]);

                if(i== curEnd){ //if we finished this range
                    jump++;
                    curEnd = curMax;
                }
            }
            return jump;

        }

        /**
         n^2 dp
         */
    /*public int jump(int[] nums) {
        int n= nums.length;
        int dp[] = new int[n];

        dp[n-1]= 0;

        for(int i=n-2 ;i>=0; i--){
            dp[i] = Integer.MAX_VALUE;

            for(int j=i+1; j<n && j<= i+ nums[i]  ;j++){
                if(dp[j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1+ dp[j]);
            }
        }
        return dp[0];

    }*/
    }