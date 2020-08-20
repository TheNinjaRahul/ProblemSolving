package com.company.leetcode.array;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    public static void main(String[] args) {
        int data2[] = {2, 7, 9, 3, 1};
        System.out.println(rob(data2));
        int data[] = {1, 2, 3, 1};
        System.out.println(rob(data));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];

    }

    public static int rob2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        return rec(nums, 0, map);

    }


    private static int rec(int[] nums, int i, Map<Integer, Integer> map) {
        if (i >= nums.length) return 0;
        if (map.containsKey(i)) return map.get(i);
        int consider = nums[i] + rec(nums, i + 2, map);
        int skip = rec(nums, i + 1, map);
        int max = Math.max(consider, skip);
        map.put(i, max);
        return max;
    }
}
