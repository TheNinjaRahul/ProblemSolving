package com.company.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] v = str.split(" ");
        Set<String> set = new HashSet<String>();
        if (v.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (set.contains(v[i])) return false;
                map.put(pattern.charAt(i), v[i]);
                set.add(v[i]);
                continue;
            }
//            System.out.println(map);
            if (!map.get(pattern.charAt(i)).equals(v[i])) return false;
        }
        return true;
    }
}
