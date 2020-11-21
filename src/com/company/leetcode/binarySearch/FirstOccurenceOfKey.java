package com.company.leetcode.binarySearch;

public class FirstOccurenceOfKey {
    public static void main(String[] args) {
        System.out.println(findFirstOccrence(new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 55},
                3));
        System.out.println(findFirstOccrence(new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 55},
                1));
    }

    public static int findFirstOccrence(int[] a, int val) {
        int start = 0;
        int end = a.length;
        int mid = 0;
        int ans = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (a[mid] == val) {
                ans = mid;
                end = mid - 1;
                continue;
            }
            if (a[mid] < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
