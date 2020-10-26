package com.company.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

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

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                while (map.containsKey(s.charAt(end))) {
                    map.remove(s.charAt(start));
                    start++;
                }
            }
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            max = Math.max(max, map.size());
        }

        return max;
    }
}
