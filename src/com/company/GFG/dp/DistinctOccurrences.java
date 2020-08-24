package com.company.GFG.dp;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;

public class DistinctOccurrences {

    public static void main(String[] args) {
        DistinctOccurrences d = new DistinctOccurrences();
        System.out.println(d.subsequenceCount("geeksforgeeks", "ge"));
    }


    int subsequenceCount(String S, String T) {
        Map<String, Integer> map = new HashMap<>();
        return rec(S, T, map, S.length() - 1, T.length() - 1, T.length());
    }

    private int rec(String s, String t, Map<String, Integer> map, int i, int j, int length) {
        if (length == 0) return 1;
        if (s.length() < t.length()) return 0;

        if (i < 0 || j < 0 || j > i) {
            return 0;
        }

        String temp = i + "-" + j;
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count = rec(s, t, map, i - 1, j - 1, length - 1) + rec(s, t, map, i - 1, j, length);
        } else {
            count = rec(s, t, map, i - 1, j, length);
        }
        map.put(temp, count);
        return count;
    }


    int subsequenceCount2(String S, String T) {
        Map<String, Integer> map = new HashMap<>();
        return rec(S, T, map);
    }

    int rec(String S, String T, Map<String, Integer> map) {

        if (S.length() == 0 && T.length() != 0) return 0;
        if (T.length() == 0) return 1;
        if (S.length() == 0) return 0;
        if (map.containsKey(S + "," + T)) {
            System.out.println(S + "," + T);
            System.out.println(map);
            return map.get(S + "," + T);
        }
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                count += subsequenceCount(S.substring(i + 1), T.substring(1));
                map.put(S + "," + T, count);
            }
        }
        return count;
    }
}
