package com.company.leetcode.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PermutationsII {

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int num[] = new int[map.size()];
        int freq[] = new int[map.size()];

        int i = 0;
        for (int key : map.keySet()) {
            num[i] = key;
            freq[i] = map.get(key);
            i++;
        }

        List<List<Integer>> output = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();

        dfs(num, freq, output, current, nums.length);
        return output;
    }


    public static void dfs(int[] num, int[] freq, List<List<Integer>> output, LinkedList<Integer> current, int length) {
        if (current.size() == length) {
            output.add(new LinkedList<>(current));
            return;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                current.add(num[i]);
                freq[i]--;
                dfs(num, freq, output, current, length);
                current.removeLast();
                freq[i]++;
            }
        }
    }
}
