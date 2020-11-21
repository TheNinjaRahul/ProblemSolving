package com.company.leetcode.binarySearch;

public class SimpleBinarySearch {
    public static void main(String[] args) {
        System.out.println(contains(new int[]{1, 2, 3, 4, 5}, 5));
    }

    public static boolean contains(int[] a, int val) {
        int start = 0;
        int end = a.length;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (a[mid] == val) return true;

            if (a[mid] < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

}
