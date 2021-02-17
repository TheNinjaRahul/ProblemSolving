package com.company.leetcode.string;

public class PalindromePartitioningIV {
    public static void main(String[] args) {
        PalindromePartitioningIV p = new PalindromePartitioningIV();

        System.out.println(p.checkPartitioning("abcbdd"));
    }

    public boolean checkPartitioning(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                if (i + 1 < s.length() && checkForTwoPartion(s, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForTwoPartion(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            boolean left = isPalindrome(s, start, i);
            boolean right = i + 1 < s.length() && isPalindrome(s, i + 1, s.length() - 1);
            if (left && right) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
