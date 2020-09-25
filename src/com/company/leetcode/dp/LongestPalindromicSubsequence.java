package com.company.leetcode.dp;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }

    public static int longestPalindromeSubseq(String s) {

        String rev = new StringBuilder(s).reverse().toString();
        return LCS(s, rev);
    }

    private static int LCS(String s, String rev) {
        int dp[][] = new int[s.length() + 1][rev.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= rev.length(); j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else if (dp[i][j - 1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][rev.length()];
    }
}
