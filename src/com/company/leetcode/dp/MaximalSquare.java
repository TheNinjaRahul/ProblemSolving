package com.company.leetcode.dp;

import com.company.GFG.dp.ArrayUtil;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] mat = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        MaximalSquare ms = new MaximalSquare();
        System.out.println(ms.maximalSquare(mat));
    }

    public int maximalSquare(char[][] matrix) {
        int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        ArrayUtil.print(dp);
        return max * max;
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
