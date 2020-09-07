package com.company.leetcode.dp;

import com.company.GFG.dp.ArrayUtil;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] d = {2, 3, 5, 6, 8, 10};
        System.out.println(subarraySum(d, 10));
    }

    public static int subarraySum(int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][k + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < k + 1; i++) {
            dp[0][i] = 0;
        }

        ArrayUtil.print(dp);
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            System.out.println("*************************");
            ArrayUtil.print(dp);
        }
        return dp[nums.length][k];
    }
}
