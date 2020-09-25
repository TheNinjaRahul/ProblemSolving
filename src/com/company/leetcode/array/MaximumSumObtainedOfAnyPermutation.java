package com.company.leetcode.array;

import java.util.*;

public class MaximumSumObtainedOfAnyPermutation {
    public static void main(String[] args) {
        int d[] = {1, 8, 5, 5, 2};
        int r[][] = {{4, 4}, {3, 4}, {4, 4}, {2, 4}, {0, 0}};
        MaximumSumObtainedOfAnyPermutation m = new MaximumSumObtainedOfAnyPermutation();
        System.out.println(m.maxSumRangeQuery(d, r));
    }

    public int maxSumRangeQuery(int[] nums, int[][] r) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        dfs(output, new HashSet<Integer>(), nums);

        int max = 0;
        for (List<Integer> list : output) {
            int sum = 0;
            for (int[] in : r) {
                for (int i = in[0]; i <= in[1]; i++) {
                    sum += list.get(i);
                }
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void dfs(List<List<Integer>> output, Set<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (Integer i : temp) {
                list.add(nums[i]);
            }
            output.add(list);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(i)) {
                    continue;
                }
                temp.add(i);
                dfs(output, temp, nums);
                temp.remove(i);
            }
        }
    }
}
