package com.company.leetcode.recursion;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        System.out.println(subsets(data));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    list.add(nums[nums.length - 1 - j]);
                }
            }
            output.add(list);
        }
        return output;
    }


    public static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        for (int n : nums) {
            if (output.size() == 0) {
                List<Integer> inner = new ArrayList<>();
                inner.add(n);
                output.add(inner);
                continue;
            } else {
                List<List<Integer>> output2 = new ArrayList<>();
                for (List<Integer> list : output) {
                    List<Integer> inner = new ArrayList<>(list);
                    inner.add(n);
                    output2.add(inner);
                }
                output.addAll(output2);
            }
            List<Integer> inner = new ArrayList<>();
            inner.add(n);
            output.add(inner);
        }

        List<Integer> blank = new ArrayList<>();
        output.add(blank);
        return output;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new LinkedList<>();
        rec(result, current, 0, nums);
        return result;
    }

    private static void rec(List<List<Integer>> result, List<Integer> current, int i, int[] nums) {

        if (i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        rec(result, current, i + 1, nums);
        current.remove(current.size() - 1);
        rec(result, current, i + 1, nums);
    }


}
