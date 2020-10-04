package com.company.leetcode.array;

import java.util.Arrays;

public class SpecialArrayX {
    public static void main(String[] args) {
        int data[] = {3, 5};
        System.out.println(specialArray(data));
    }

    /*
    TODO need to implement
     */
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int x = nums.length;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= i) {
                int temp = x - i + 1;
                if (temp == i) {
                    result = temp;
                }
            }
        }
        return result;
    }
}
