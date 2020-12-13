package com.company.leetcode.array;

public class IsMountainArray {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));
    }

    public static boolean validMountainArray(int[] a) {
        int i = 0;
        while (i + 1 < a.length && a[i] < a[i + 1]) {
            i++;
        }
        if (i == a.length) return false;
        while (i + 1 < a.length && a[i] > a[i + 1]) {
            i++;
        }
        return (i == a.length - 1);
    }


}
