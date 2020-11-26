package com.company.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {

    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero m = new MinimumOperationsToReduceXToZero();
        System.out.println(m.minOperations(new int[]{1, 2, 3, 4}, 10));
    }

    public int minOperations(int[] nums, int x) {
        Map<String, Integer> map = new HashMap<>();
        int ans = rec(nums, x, 0, nums.length - 1, map, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int rec(int[] a, int x, int i, int end, Map<String, Integer> map, int count) {
        if (x == 0) {
            return count;
        }
        if (i > end) return Integer.MAX_VALUE;
        String key = i + "*" + end + "*";
        if (map.containsKey(key)) return map.get(key);
        int left = rec(a, x - a[i], i + 1, end, map, count + 1);
        int right = rec(a, x - a[end], i, end - 1, map, count + 1);
        int result = Math.min(left, right);
        map.put(key, result);
        return result;
    }
}
