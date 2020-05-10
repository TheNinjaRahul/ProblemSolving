package com.company.leetcode;

import java.util.*;

public class MaxNonRepeatingString {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (len < set.size()) {
                    len = set.size();
                }

                Iterator<Character> iterator = set.iterator();
                List<Character> list = new ArrayList<>();
                while (iterator.hasNext()) {
                    if (iterator.next().equals(s.charAt(i))) {
                        while (iterator.hasNext()) {
                            list.add(iterator.next());
                        }
                    }
                }
                set.clear();
                set.addAll(list);

            }

            set.add(s.charAt(i));
        }
        if (len < set.size()) {
            len = set.size();
            set.clear();
        }

        return len;

    }
}
