package com.company.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] val = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                val[i++] = e.getKey();
            }
            if (i == 2) break;
        }
        return val;
    }
}
