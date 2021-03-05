package com.company.leetcode.dp;

import java.util.Arrays;

public class MaximumScoreFromPerformingMultiplicationOperations {
    public static void main(String[] args) {

    }

    public int maximumScore(int[] nums, int[] mul) {
        int[][] dp = new int[1001][1001];
        for (int a[] : dp) {
            // for(int b[]:a)
            Arrays.fill(a, -1);
        }
        return dp(nums, mul, 0, 0, dp);
    }

    public int dp(int[] nums, int[] mul, int s, int k, int[][] dp) {
        if (s >= nums.length || k >= mul.length) return 0;
        int end = nums.length - (s - k) - 1;
        if (end >= nums.length || end < 0) return 0;
        if (dp[s][k] != -1) return dp[s][k];
        int op1 = nums[s] * mul[k] + dp(nums, mul, s + 1, k + 1, dp);
        int op2 = nums[end] * mul[k] + dp(nums, mul, s, k + 1, dp);
        dp[s][k] = Math.max(op1, op2);
        return dp[s][k];
    }
}
