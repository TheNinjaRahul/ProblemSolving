package com.company.leetcode.dp;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode", list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);

        return rec(s, 0, set, map);

    }

    private static boolean rec(String s, int i, Set<String> set, Map<Integer, Boolean> map) {

        if (i == s.length()) return true;
        if (map.containsKey(i)) {
            return map.get(i);
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int j = i; j < s.length(); j++) {
            sb.append(s.charAt(j));
            if (set.contains(sb.toString())) {
                if (rec(s, j + 1, set, map)) {
                    return true;
                }
            }
        }
        map.put(i, flag);
        return flag;
    }
}
