package com.company.leetcode.array;

public class MaximumScoreFromPerformingMultiplicationOperations {
    int ans = 0;

    public int maximumScore(int[] nums, int[] multipliers) {
        int i = 0, j = nums.length - 1;
        int k = 0;
        int mul = multipliers[k];
        int a = mul * nums[i];
        int b = mul * nums[j];
        checkAll(a, i + 1, j, k + 1, nums, multipliers);
        checkAll(b, i, j - 1, k + 1, nums, multipliers);
        return ans;
    }

    private void checkAll(int sum, int i, int j, int k, int[] nums, int[] multipliers) {
        ans = Math.max(ans, sum);
        if (k >= multipliers.length) return;
        if (i >= nums.length) return;
        if (j < 0) return;
        int mul = multipliers[k];
        int a = mul * nums[i];
        int b = mul * nums[j];
        checkAll(a + sum, i + 1, j, k + 1, nums, multipliers);
        checkAll(b + sum, i, j - 1, k + 1, nums, multipliers);
    }
}
