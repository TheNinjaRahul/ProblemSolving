package com.company.leetcode.array;

public class FormArrayByConcatenatingSubarraysOfAnotherArray {
    public static void main(String[] args) {
        System.out.println(canChoose(new int[][]{{6551094, 9427527, 2052462, 3481286, -7620442}, {8495362, -1820796}, {-1005271, -6911519}, {-9667242, 9997184, -9316362}, {-9278108, -7479063, -7573091, -1775876, -2612810, -241649}},
                new int[]{6551094, 6551094, 9427527, 2052462, 3481286, -7620442, -7620442, 8495362, -1820796, -1005271, -6911519, -9667242, 9997184, -9316362, 9997184, -9278108, -7479063, -7573091, -1775876, -2612810, -241649}));
        System.out.println(canChoose(new int[][]{{10, -2}, {1, 2, 3, 4}}, new int[]{1, 2, 3, 4, 10, -2}));
        System.out.println(canChoose(new int[][]{{1, -1, -1}, {3, -2, 0}}, new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0}));

    }

    public static boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        int j = 0;
        while (i < groups.length && j < nums.length) {
            int a[] = groups[i];
            int k = 0;
            while (k < a.length && j < nums.length) {
                if (a[k] == nums[j]) {
                    k++;
                    j++;
                } else {
                    if (k > 0) {
                        k = 0;
                    } else {
                        j++;
                    }
                }
            }
            if (k == a.length) {
                i++;
                if (i >= groups.length) return true;
            }

        }
        return false;
    }
}
