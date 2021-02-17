package com.company.leetcode.string;

import java.util.Arrays;

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(tt);
        Arrays.sort(ss);

        for (int i = 0; i < t.length(); i++) {
            if (ss[i] != tt[i]) return false;
        }
        return true;

    }
}
