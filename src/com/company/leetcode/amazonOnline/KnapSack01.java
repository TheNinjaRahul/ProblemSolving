package com.company.leetcode.amazonOnline;

import java.util.HashMap;
import java.util.Map;

public class KnapSack01 {
    public static void main(String[] args) {
        System.out.println(getMaxProfit(new int[]{3, 4, 1}, new int[]{5, 6, 2}, 6));
    }

    public static int getMaxProfit(int w[], int p[], int bw) {
        Map<Integer, Integer> map = new HashMap<>();
        return rec(w, p, bw, map, w.length - 1);
    }

    private static int rec(int[] w, int[] p, int bw, Map<Integer, Integer> map, int i) {
        if (i < 0) return 0;
        if (map.containsKey(i)) return map.get(i);
        int result = 0;
        if (w[i] < bw) {
            result = p[i] + rec(w, p, bw - w[i], map, i - 1);
        }
        result = Math.max(result, rec(w, p, bw, map, i - 1));
        map.put(i, result);
        return result;
    }
}
