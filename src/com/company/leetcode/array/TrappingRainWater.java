package com.company.leetcode.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] data = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(data));
    }

    private static int trap(int[] data) {
        int l = 0, h = data.length - 1, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE, result = 0;


        while (l <= h) {
            if (data[l] <= data[h]) {
                if (leftMax < data[l]) {
                    leftMax = data[l];
                } else {
                    result += leftMax - data[l];
                }
                l++;
            } else {
                if (rightMax < data[h]) {
                    rightMax = data[h];
                } else {
                    result += rightMax - data[h];
                }
                h--;
            }

        }

        return result;

    }
}
