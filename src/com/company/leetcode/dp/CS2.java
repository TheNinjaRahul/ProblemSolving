package com.company.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class CS2 {
    public static void main(String[] args) {
        CS2 a = new CS2();
        System.out.println(a.climbStairs(2));
    }

    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return rec(0, n, map);
    }

    public int rec(int i, int n, Map<Integer, Integer> map) {
        if (i == n) return 1;
        if (i > n) return 0;
        if (map.containsKey(i)) return map.get(i);
        int a = rec(i + 1, n, map);
        int b = rec(i + 2, n, map);
        map.put(i, a + b);
        return a + b;
    }
}
