package com.company.leetcode.dp;

public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ABCDGH", "AEDFHR"));
        System.out.println(longestCommonSubsequence("abcde", "ace"));

    }

    public static String longestCommonSubsequence(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = s1.length();
        int j = s2.length();

        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        return sb.reverse().toString();
    }
}
