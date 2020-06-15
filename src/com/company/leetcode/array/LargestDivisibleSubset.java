package com.company.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
//        int[] d = {1, 2, 3};
        int[] d ={2,3,4,6,8,10,24};
        System.out.println(largestDivisibleSubset(d));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return list;
        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);

        int a[] = new int[nums.length];
        int al[] = new int[nums.length];
        a[nums.length - 1] = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int maxIndex = -1, max = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0) {
                    int l = findLength(j, a);
                    if (max < l) {
                        max = l;
                        maxIndex = j;
                    }
                }
            }
            a[i] = maxIndex;
        }

        int max = 0, index = -1;
        for (int i = 0; i < nums.length; i++) {
            int temp = i;
            int count = 0;
            while (a[temp] != -1) {
                temp = a[temp];
                count++;
            }
            if (count > max) {
                max = count;
                index = i;
            }
        }

        while (index != -1) {
            list.add(nums[index]);
            index = a[index];
        }
        if (list.isEmpty()) {
            list.add(nums[0]);
        }
        return list;
    }

    private static int findLength(int j, int[] a) {
        int count = 1;
        while (a[j] != -1) {
            j = a[j];
            count++;
        }
        return count;
    }
}
