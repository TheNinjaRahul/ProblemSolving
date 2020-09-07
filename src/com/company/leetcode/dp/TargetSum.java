package com.company.leetcode.dp;

import com.company.GFG.dp.ArrayUtil;

public class TargetSum {
    public static void main(String[] args) {
        int data[] = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(findTargetSumWays(data, 1));
    }

    public static int findTargetSumWays(int[] nums, int S) {


        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (S > sum || (sum + S) % 2 != 0)
            return 0;

        int findSumSubset = (S + sum) / 2;
        return findSubSetSum(nums, findSumSubset);
    }

    public static int findSubSetSum(int[] nums, int findSumSubset) {
        int[][] dp = new int[nums.length + 1][findSumSubset + 1];
//        for (int i = 0; i <= nums.length; i++) {
//            dp[i][0] = 1;
//        }

        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= findSumSubset; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
            System.out.println("*************");
            ArrayUtil.print(dp);
        }
        return dp[nums.length][findSumSubset];

    }
}
