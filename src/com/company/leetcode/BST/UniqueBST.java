package com.company.leetcode.BST;

public class UniqueBST {
    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }

    public static int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int a = i - j - 1;
                dp[i] += dp[j] * dp[a];
            }
        }
        return dp[n];
    }
}
