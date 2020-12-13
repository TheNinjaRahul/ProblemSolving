package com.company.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumNumberOfRemovalsToMakeMountainArray {
    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1}));
    }

    public static int minimumMountainRemovals(int[] nums) {
        List<int[]> increasingList = new LinkedList<>();
        List<int[]> increasingListFromLast = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i + 1 < nums.length && nums[i] < nums[i + 1]) {
                i++;
            }
            increasingList.add(new int[]{start, i});
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int end = i;
            while (i - 1 >= 0 && nums[i - 1] > nums[i]) {
                i--;
            }
            increasingListFromLast.add(new int[]{i, end});
        }

//        for (int[] a : increasingList) {
//            System.out.println(Arrays.toString(a));
//        }
//
//        System.out.println("increasing from last");
//        for (int[] a : increasingListFromLast) {
//            System.out.println(Arrays.toString(a));
//        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < increasingList.size(); i++) {
            int a[] = increasingList.get(i);
            for (int j = 0; j < increasingListFromLast.size(); j++) {
                int b[] = increasingListFromLast.get(j);
                if (a[1] <= b[0]) {
                    int len = a[1] - a[0] + 1;
                    len += b[1] - b[0] + 1;
                    if (a[1] == b[0]) {
                        len--;
                    }
                    min = Math.min(min, nums.length - len);
                }
            }
        }
        return min;
    }
}
