package com.company.leetcode.recursion;

import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        String[] str = {"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> list = Arrays.asList(str);
        System.out.println(wordBreak(s, list));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        Map<String, List<String>> map = new HashMap<>();

        return rec(s, 0, set, map);

    }

    private static List<String> rec(String s, int start, Set<String> set, Map<String, List<String>> map) {
        String key = start + ":" + s.substring(start, s.length());
        if (map.containsKey(key)) {
            return map.get(key);
        }

        List<String> list = new LinkedList<>();
        if (start == s.length()) {
            list.add("");
        }

        for (int end = start + 1; end < 1 + s.length(); end++) {
            String prefix = s.substring(start, end);
            if (set.contains(prefix)) {
                List<String> suffix = rec(s, end, set, map);
                for (String suffixStr : suffix) {
                    list.add(prefix + (suffixStr.equals("") ? "" : " " + suffixStr));
                }
            }
        }
        map.put(key, list);
        return list;
    }


}
