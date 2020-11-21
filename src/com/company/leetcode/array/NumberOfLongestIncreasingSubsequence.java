package com.company.leetcode.array;

import java.util.LinkedList;
import java.util.*;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] d = {1, 3, 5, 4, 7};
        NumberOfLongestIncreasingSubsequence nis = new NumberOfLongestIncreasingSubsequence();
        int d2[] = {2, 2, 2, 2, 2};
        System.out.println(nis.findNumberOfLIS(d));
        System.out.println(nis.findNumberOfLIS(d2));
    }

    public int findNumberOfLIS(int[] nums) {
        Map<Integer, List<List<Integer>>> map = new TreeMap<>(Collections.reverseOrder());
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[nums.length - 1]);
        getList(nums, map, list, nums.length - 2);
        System.out.println(map);
        return map.get(map.keySet().iterator().next()).size();
    }


    public void getList(int[] nums, Map<Integer, List<List<Integer>>> map, LinkedList<Integer> list, int i) {
        if (i == 0) {
            if (nums[i] <= list.get(0)) {
                list.addFirst(nums[i]);
                if (map.containsKey(list.size())) {
                    map.get(list.size()).add(new LinkedList<>(list));
                } else {
                    map.put(list.size(), new LinkedList<>());
                    map.get(list.size()).add(new LinkedList<>(list));
                }
            }
            return;
        }

        if (nums[i] <= list.getFirst()) {
            getList(nums, map, new LinkedList<>(list), i - 1);
            list.addFirst(nums[i]);
            if (map.containsKey(list.size())) {
                map.get(list.size()).add(new LinkedList<>(list));
            } else {
                map.put(list.size(), new LinkedList<>());
                map.get(list.size()).add(new LinkedList<>(list));
            }
            getList(nums, map, new LinkedList<>(list), i - 1);
        } else {
            getList(nums, map, new LinkedList<>(list), i - 1);
        }
        LinkedList<Integer> newOne = new LinkedList<>();
        newOne.add(nums[i]);
        getList(nums, map, newOne, i - 1);
    }
}
