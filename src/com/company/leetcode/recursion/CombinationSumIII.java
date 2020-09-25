package com.company.leetcode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> l = new LinkedList<>();
            l.add(nums[i]);
            rec(nums, l, i + 1, k, n, list);
        }
        return list;
    }

    private static void rec(int[] nums, List<Integer> list, int i, int k, int n, List<List<Integer>> lists) {
        if (i >= nums.length) return;
        if (list.size() >= k) return;
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            rec(nums, list, j + 1, k, n, lists);
            int sum = list.stream().reduce(0, (a, b) -> a + b);
            if (sum == n && list.size() == k) {
                lists.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
        }
    }
}
