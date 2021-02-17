package com.company.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {

    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero m = new MinimumOperationsToReduceXToZero();
        System.out.println(m.minOperations(new int[]{1, 2, 3, 4}, 10));
        System.out.println(m.minOperations2(new int[]{1, 2, 3, 4}, 10));
    }

    public int minOperations2(int[] nums, int x) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = Integer.MAX_VALUE;
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < x) {
                map.put(sum, i + 1);
            } else {
                if (sum == x) {
                    res = i + 1;
                }
                break;
            }
        }

        sum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            int temp = x - sum;
            if (map.containsKey(temp)) {
                res = Math.min(res, nums.length - i + map.get(temp));
            }
            if (sum > x) break;
        }
        return res;
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
