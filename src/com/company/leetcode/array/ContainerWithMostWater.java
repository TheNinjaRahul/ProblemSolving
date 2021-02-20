package com.company.leetcode.array;

import java.util.Arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2, 1}));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }


    public static int maxArea(int[] h) {
        int n = h.length;
        int lmax = 0;
        int rmax = n - 1;
        int leftMax[] = new int[h.length];
        int rightMax[] = new int[h.length];
        leftMax[0] = 0;
        rightMax[n - 1] = n - 1;
        for (int i = 1; i < n; i++) {
            if (h[i] > h[lmax]) {
                lmax = i;
            }
            leftMax[i] = lmax;
        }

        for (int i = n - 1; i >= 1; i--) {
            if (h[i] > h[rmax]) {
                rmax = i;
            }
            rightMax[i] = rmax;
        }

        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, (rightMax[i] - leftMax[i]) * h[i]);
        }
        return ans;
    }

}
