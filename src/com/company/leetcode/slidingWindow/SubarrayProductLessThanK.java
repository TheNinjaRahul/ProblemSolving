package com.company.leetcode.slidingWindow;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        int data[] = {10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(data, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k == 0) return 0;
        long product = 1l;
        int count = 0;
        int start = 0, end = 0;

        while (end < nums.length) {
            product *= nums[end];
            while (product >= k) {
                product /= nums[start++];
            }
            count += 1 + (end - start);
            end++;
        }
        return count;

    }

}
