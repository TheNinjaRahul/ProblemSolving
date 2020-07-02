package com.company.leetcode.number;

public class PerfectSquares {
    public static void main(String[] args) {
        int num = 12;
        System.out.println(numSquares(num));
    }

    public static int numSquares(int n) {

        int[] dp=new int[n+1];
        return rec(n,dp);

    }

    private static int rec(int n, int[] dp) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        if(dp[n]>0) return dp[n];
        int min = n;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(rec(n - (i * i),dp), min);
        }
        dp[n]=1+min;
        return 1+min;
    }


}
