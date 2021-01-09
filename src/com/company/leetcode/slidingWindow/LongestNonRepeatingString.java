package com.company.leetcode.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingString {
    public static void main(String[] args) {
        LongestNonRepeatingString l = new LongestNonRepeatingString();
        System.out.println(l.lengthOfLongestSubstring("abcdefabcdefg"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            if (set.contains(s.charAt(end))) {
                max = Math.max(max, (end - start));
                while (set.contains(s.charAt(end))) {
                    set.remove(s.charAt(start++));
                }
            }
            set.add(s.charAt(end));
        }
        return Math.max(set.size(), max);
    }
}
