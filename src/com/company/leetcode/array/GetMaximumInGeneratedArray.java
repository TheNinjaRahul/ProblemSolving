package com.company.leetcode.array;

public class GetMaximumInGeneratedArray {
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }

    public static int getMaximumGenerated(int n) {
        int[] a = new int[n + 1];
        if (n > 2) {
            if (n == 0) return 0;
            if (n == 1) return 1;
        }
        a[0] = 0;
        a[1] = 1;
        for (int i = 1; i < (n / 2) + 1; i++) {
            int x = i * 2;
            a[x] = a[i];
            int y = (i * 2) + 1;
            if (y <= n) {
                a[(i * 2) + 1] = a[i] + a[i + 1];
            }
        }

        int max = 0;
        for (int i : a) {
            max = Math.max(i, max);
        }

        return max;
    }

}
