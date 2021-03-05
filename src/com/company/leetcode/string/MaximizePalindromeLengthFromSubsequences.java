package com.company.leetcode.string;

public class MaximizePalindromeLengthFromSubsequences {
    public static void main(String[] args) {
        MaximizePalindromeLengthFromSubsequences m = new MaximizePalindromeLengthFromSubsequences();
        System.out.println(m.longestPalindrome("cacb", "cbba"));
    }

    public int longestPalindrome(String word1, String word2) {
        int ans = 0;
        for (int k = 0; k < word1.length(); k++) {
            for (int i = k; i < word1.length(); i++) {
                for (int j = 0; j < word2.length(); j++) {
                    String str = word1.substring(k, i + 1) + word2.substring(0, j + 1);
                    if (isPalid(str)) {
                        if (ans < str.length()) {
                            ans = str.length();
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalid(String s) {
        System.out.println(s);
        int i = 0, j = s.length() - 1;
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
