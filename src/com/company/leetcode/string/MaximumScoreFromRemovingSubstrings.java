package com.company.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
    }

    public static int maximumGain(String s, int x, int y) {
        Map<String, Integer> map = new HashMap<>();
        return maxValue(s, x, y, map);
    }

    private static int maxValue(String s, int x, int y, Map<String, Integer> map) {
        if (map.containsKey(s)) return map.get(s);
        int ansx = 0;
        int ansy = 0;
        if (s.contains("ab")) {
            ansx = x;
            ansx += maxValue(s.replaceFirst("ab", ""), x, y, map);
        }
        if (s.contains("ba")) {
            ansy = y;
            ansy += maxValue(s.replaceFirst("ba", ""), x, y, map);
        }
        map.put(s, Math.max(ansx, ansy));
        return map.get(s);
    }

}
