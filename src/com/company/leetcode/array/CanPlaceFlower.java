package com.company.leetcode.array;

public class CanPlaceFlower {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    public static boolean canPlaceFlowers(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                if (a[i + 1] == 0 && a[i] == 0) {
                    n--;
                    i++;
                }
            } else if (a.length - 1 == i && a[i] == 0) {
                if (a[i - 1] == 0) {
                    n--;
                    i++;
                }
            } else if (a[i] == 0 && a[i + 1] == 0 && a[i - 1] == 0) {
                i++;
                n--;
            }
        }
        return n <= 0;
    }
}
