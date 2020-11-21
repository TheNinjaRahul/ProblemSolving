package com.company.leetcode.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(lis.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j] && lis[i] < 1 + lis[j]) {
                    lis[i] = 1 + lis[j];
                    max = Math.max(lis[i], max);
                }
            }
        }
        return max;
    }

}
