package com.company.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class NiceString {
    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
    }

    public static String longestNiceSubstring(String s) {
        int max = 0;
        String ans = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                Set<Character> lower = new HashSet<>();
                Set<Character> upper = new HashSet<>();
                for (char c : sub.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        upper.add(c);
                    } else {
                        lower.add(c);
                    }
                }
                boolean f = false;
                for (char c : sub.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        if (!lower.contains(Character.toLowerCase(c))) {
                            f = true;
                            break;
                        }
                    } else {
                        if (!upper.contains(Character.toUpperCase(c))) {
                            f = true;
                            break;
                        }
                    }
                }
                if (!f) {
                    if (max < sub.length()) {
                        max = sub.length();
                        ans = sub;
                    }
                }
            }
        }
        return ans;
    }
}
