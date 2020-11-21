package com.company.leetcode.array;

public class LongestMountainInArray {
    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{1, 2, 3, 4, 5, 6, 8}));
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }

    public static int longestMountain(int[] a) {
        boolean ao = true;
        int i = 0;

        int start = 0;
        int end = 0;
        int max = 0;
        while (i < a.length) {
            start = i;
            while (i + 1 < a.length && a[i] < a[i + 1]) {
                i++;
            }
            if (i == start) {
                i++;
                continue;
            }
            end = i;
            while (i + 1 < a.length && a[i] > a[i + 1]) {
                i++;
            }
            if (i == end) {
                i++;
                continue;
            }
            end = i;
            max = Math.max(max, end - start + 1);
            i++;
        }

        return max;
    }
}
