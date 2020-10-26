package com.company.leetcode.amazonOnline;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int start = 0;

        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int end = 0; end < s.length(); end++) {
            if (set.contains(s.charAt(end))) {
                while (set.contains(s.charAt(end))) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(s.charAt(end));
            max = Math.max(max, set.size());
        }

        return max;
    }
}
