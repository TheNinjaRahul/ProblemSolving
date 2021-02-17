package com.company.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        MaxNumberOfKSumPairs m = new MaxNumberOfKSumPairs();

        System.out.println(m.maxOperations(new int[]{5, 4, 4, 3, 4, 4, 4, 4, 3, 2, 4, 2}, 3));
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            if (map.containsKey(k - i)) {
                count++;
                if (map.get(k - i) == 1) {
                    map.remove(k - i);
                } else {
                    map.put(k - i, map.get(k - i) - 1);
                }
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return count;
    }

}
