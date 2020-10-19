package com.company.leetcode.array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] d = {1, 2, 3, 4, 5, 6};
        RotateArray r = new RotateArray();
        r.rotate(d, 5);
        System.out.println(Arrays.toString(d));
    }

    public void rotate(int[] nums, int k) {
        if (k == 0 || k == nums.length || nums.length == 1) return;
        k = k % nums.length;
        int temp = nums[0];
        int j = k;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j == start) {
                int t = nums[j];
                nums[j] = temp;
                temp = t;
                j++;
                start = j;
                temp = nums[j];
                j = (j + k) % nums.length;
            } else {
                int t = nums[j];
                nums[j] = temp;
                temp = t;
                j = (j + k) % nums.length;
            }
        }
    }
}
