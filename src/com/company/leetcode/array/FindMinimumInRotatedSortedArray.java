package com.company.leetcode.array;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {

        int[] data2 = {3, 1, 2};
        System.out.println(findMin(data2));
        int[] data = {3, 4, 5, 1, 2};
        System.out.println(findMin(data));
    }

    public static int findMin(int[] a) {
        int l = 0, r = a.length - 1;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (a[mid] < a[r]) {
                r = mid;
            } else if (a[mid] > a[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return a[l];
    }
}
