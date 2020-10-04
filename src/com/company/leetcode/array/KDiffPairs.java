package com.company.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairs {
    public static void main(String[] args) {
        KDiffPairs kp = new KDiffPairs();
        int[] data = {3, 1, 4, 1, 5};
        System.out.println(kp.findPairs(data, 2));
    }

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(map);
        int count = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = Math.max(k, nums[i]) - Math.min(k, nums[i]);
            String key = "";
            if (nums[i] < diff) {
                key += nums[i] + "_" + diff;
            } else {
                key += diff + "_" + nums[i];
            }
            if (map.containsKey(diff) && Math.abs(map.get(diff) - nums[i]) == k && !set.contains(key)) {
                System.out.println(diff + "-->" + nums[i]);
                count++;
                set.add(key);
            }
        }
        return count;
    }
}
