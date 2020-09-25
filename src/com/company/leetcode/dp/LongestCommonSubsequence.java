package com.company.leetcode.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println();
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(s1, s2, dp, s1.length() - 1, s2.length() - 1);
    }

    private int rec(String s1, String s2, int[][] dp, int i, int j) {

        if (i == -1 || j == -1) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + rec(s1, s2, dp, i - 1, j - 1);
        } else {
            dp[i][j] = Math.max(rec(s1, s2, dp, i - 1, j), rec(s1, s2, dp, i, j - 1));
        }

        return dp[i][j];
    }
}
