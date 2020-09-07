package com.company.leetcode.array;

import java.util.*;

public class ContainsDuplicateIII {
    public static void main(String[] args) {


        int[] data3 = {1, 2, 3, 1};
        System.out.println("true:" + containsNearbyAlmostDuplicate(data3, 3, 0));


        int[] data = {1, 0, 1, 1};
        System.out.println("true:" + containsNearbyAlmostDuplicate(data, 1, 2));

        int[] data2 = {1, 5, 9, 1, 5, 9};
        System.out.println("false:" + containsNearbyAlmostDuplicate(data2, 2, 3));


    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int i = 0;
        while (i < nums.length) {
            for (int j = i + 1; j < nums.length && j <= k + i; j++) {
                if (Math.abs(1L * nums[i] - nums[j]) <= t) return true;
            }
            i++;
        }
        return false;
    }
}
