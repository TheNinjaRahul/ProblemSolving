package com.company.leetcode.dp;

import java.util.Arrays;

public class MinPartitioningPalindrome {
    public static void main(String[] args) {
        MinPartitioningPalindrome m = new MinPartitioningPalindrome();
        System.out.println(m.minCut("aab"));
    }

    public int minCut(String s) {

        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, 0, s.length() - 1, dp);
    }

    public int solve(String s, int i, int j, int[][] dp) {
        if (i >= j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        if (isPalindrome(s, i, j)) {
            dp[i][j] = 0;
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {

            int left = 0, right = 0;
            if (dp[i][k] == -1) {
                left = solve(s, i, k, dp);
                dp[i][k] = left;
            } else {
                left = dp[i][k];
            }

            if (dp[k + 1][j] == -1) {
                right = solve(s, k + 1, j, dp);
                dp[k + 1][j] = right;
            } else {
                right = dp[k + 1][j];
            }


            int temp = left + right + +1;
            min = Math.min(temp, min);
        }
        dp[i][j] = min;
        return min;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
