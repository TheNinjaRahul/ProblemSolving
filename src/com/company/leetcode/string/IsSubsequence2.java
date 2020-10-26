package com.company.leetcode.string;

public class IsSubsequence2 {
    public static void main(String[] args) {
        IsSubsequence2 is2 = new IsSubsequence2();
        System.out.println("True:" + is2.isSubsequence("abc", "ahbgdc"));
        System.out.println("False:" + is2.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if (s.length() == i) return true;
        return false;

    }
}
