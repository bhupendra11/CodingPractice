package com.bhupendra.prep2023.dp.knapsack;

public class _1_PartitionEqualSubSetSum {
    public boolean canPartition(int[] nums) {
        //Equal subsets mean I just need to find out 1 subset which has a sum of totalArraySum /2

        int sum = 0;
        for(int a: nums){
            sum+=a;
        }

        if(sum %2 != 0){
            return false; //unevern sum, cannot divide
        }


        return subsetSumOptimised(nums, sum/2);
    }

    private boolean subsetSum(int[] nums, int sum){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i =0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i == 0){
                    dp[i][j] = (j==0);
                }
                else if(j==0){
                    dp[i][j] = true;
                }
                else if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]]  || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    private boolean subsetSumOptimised(int[] nums, int sum){
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for(int curr : nums){
            for(int j=sum;j >=curr;j--){
                dp[j] |= dp[j- curr];
            }
        }
        return dp[sum];
    }
}
