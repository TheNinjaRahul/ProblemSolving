package com.company.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaBB"));
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome(""));
    }

    public static int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        int single = 0;
        for (int i = 0; i < 128; i++) {
            if (freq[i] % 2 != 0) {
                single++;
            }
        }
        return single > 1 ? s.length() - single + 1 : s.length();
    }

    public static int longestPalindrome2(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                if (e.getValue() % 2 == 0) {
                    count += e.getValue();
                    e.setValue(0);
                } else {
                    count += e.getValue() - 1;
                    e.setValue(1);

                }
            }
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                count++;
                break;
            }
        }

        return count;
    }


}
