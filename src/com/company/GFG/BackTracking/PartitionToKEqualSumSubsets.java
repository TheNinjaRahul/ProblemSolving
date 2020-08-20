package com.company.GFG.BackTracking;

import java.util.*;

public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {

        int[] data3 = {29, 28, 51, 85, 59, 21, 25, 23, 70, 97, 82, 31, 85, 93, 73};
        System.out.println(canPartitionKSubsets(data3, 3));

        int[] data2 = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(data2, 4));

        int[] data = {2, 1, 4, 5, 6};
        System.out.println(canPartitionKSubsets(data, 3));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int find = sum / k;

        Set<Integer> set = new HashSet<>();
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) continue;
            if (nums[i] == find) {
                set.add(i);
                count++;
            } else {
                list.add(i);
                if (dfs(nums[i], nums, i, list, set, find)) {
                    count++;
                } else {
                    return false;
                }
            }

        }
        return count == k;
    }

    private static boolean dfs(int sum, int[] nums, int current, LinkedList<Integer> list, Set<Integer> set, int find) {
        if (set.contains(current)) return false;

        for (int i = current + 1; i < nums.length; i++) {
            if (sum + nums[i] < find) {
                list.add(i);
                if (dfs(nums[i] + sum, nums, i, list, set, find)) {
                    return true;
                } else {
                    list.removeLast();
                }
            } else if (sum + nums[i] == find) {
                list.add(i);
                for (Integer index : list) {
                    System.out.print(nums[index] + " ");
                    set.add(index);
                }
                list.clear();
                return true;
            }
        }
        return false;
    }

}


