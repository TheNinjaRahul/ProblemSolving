package com.company.leetcode.amazonOnline;

import netscape.security.UserTarget;

import java.util.*;

public class SubstringsofSizeKWith1DuplicateAndOtherAllDistinctChars {
    public static void main(String[] args) {
        System.out.println(subStringAtMost2DupValue("awaglk", 4));
        System.out.println(subStringAtMost2DupValue("democracy", 5));
        System.out.println(subStringAtMost2DupValue("wawaglknagagwunagkwkwagl", 4));

//        System.out.println(subStringAtMost2DupValue("awagglaa", 4));
//        System.out.println(subStringAtMost2DupValue("aaaabcd", 4));
//        System.out.println(subStringAtMost2DupValue("abcabc", 3));

    }

    public static List<String> subStringAtMost2DupValue(String s, int k) {
        if (s.length() == 0) return new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        List<String> output = new LinkedList<>();
        boolean isTwoDupPresent = false;
        int count = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                if (isTwoDupPresent) {
                    while (map.get(c) != 1) {
                        map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                        if (map.get(s.charAt(start)) == 0) {
                            map.remove(s.charAt(start));
                        }
                        start++;
                        count--;
                    }
                }
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 2) {
                isTwoDupPresent = true;
            }
            count++;
            if (count == k) {
                output.add(s.substring(start, end + 1));
//                System.out.println(s.substring(start, end + 1));
                count--;
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                } else {
                    isTwoDupPresent = false;
                }
                start++;
            }
        }
        return output;
    }
}
