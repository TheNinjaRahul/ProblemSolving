package com.company.leetcode.dp;

import java.util.Arrays;

public class EggDropingProblem {
    public static void main(String[] args) {
        System.out.println(superEggDrop(1, 2));
        System.out.println(superEggDrop(2, 6));
        System.out.println(superEggDrop(3, 14));

    }

    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(K, N, dp);
    }

    private static int solve(int e, int noOfFloor, int[][] dp) {
        if (noOfFloor == 1 || noOfFloor == 0 || e == 1) {
            return noOfFloor;
        }

        if (dp[e][noOfFloor] != -1) {
            return dp[e][noOfFloor];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= noOfFloor; i++) {
            int low = Integer.MAX_VALUE, high = Integer.MAX_VALUE;

            if (dp[e - 1][i - 1] == -1) {
                low = solve(e - 1, i - 1, dp);
            } else {
                low = dp[e - 1][i - 1];
            }

            if (dp[e][noOfFloor - i] == -1) {
                high = solve(e, noOfFloor - i, dp);
            } else {
                high = dp[e][noOfFloor - i];
            }
            int temp = 1 + Math.max(low, high);
            min = Math.min(temp, min);
        }
        dp[e][noOfFloor] = min;
        return min;
    }
}
