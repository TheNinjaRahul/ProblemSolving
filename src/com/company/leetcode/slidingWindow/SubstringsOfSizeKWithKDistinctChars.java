package com.company.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringsOfSizeKWithKDistinctChars {
    public static void main(String[] args) {
        System.out.println(uniqueSubstringSizeK("abcabc", 3));
        System.out.println(uniqueSubstringSizeK("abacab", 3));
    }

    public static List<String> uniqueSubstringSizeK(String s, int k) {
        List<String> list = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int count = 0;
        for (int end = 0; end < s.length(); end++) {
            char startChar = s.charAt(start);
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) == 2) {
                while (map.get(c) != 1) {
                    map.put(startChar, map.get(startChar) - 1);
                    if (map.get(startChar) == 0) map.remove(startChar);
                    start++;
                    startChar = s.charAt(start);
                    count--;
                }
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            count++;
            if (count == k) {
                list.add(s.substring(start++, end + 1));
                count--;
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) map.remove(startChar);
            }
        }
        return list;
    }

}
